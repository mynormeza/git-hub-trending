package com.mynormeza.cache

import com.mynormeza.cache.db.ProjectsDatabase
import com.mynormeza.cache.mapper.CachedProjectMapper
import com.mynormeza.cache.model.Config
import com.mynormeza.data.model.ProjectEntity
import com.mynormeza.data.repository.ProjectsCache
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ProjectsCacheImpl @Inject constructor(
    private val projectsDatabase: ProjectsDatabase,
    private val mapper: CachedProjectMapper
): ProjectsCache {
    override fun clearProjects(): Completable {
        return Completable.defer {
            projectsDatabase.cachedProjectsDao().deleteProjects()
            Completable.complete()
        }
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        return Completable.defer {
            projectsDatabase.cachedProjectsDao().insertProjects(
                projects.map { mapper.mapToCache(it) }
            )
            Completable.complete()
        }
    }

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsDatabase.cachedProjectsDao().getProjects()
            .toObservable()
            .map {
                it.map {
                    mapper.mapFromCache(it)
                }
            }
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        return projectsDatabase.cachedProjectsDao().getBookmarkedProjects()
            .toObservable()
            .map {
                it.map {
                    mapper.mapFromCache(it)
                }
            }
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        return Completable.defer {
            projectsDatabase.cachedProjectsDao().setBookmarkStatus(true, projectId)
            Completable.complete()
        }
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        return Completable.defer {
            projectsDatabase.cachedProjectsDao().setBookmarkStatus(false, projectId)
            Completable.complete()
        }
    }

    override fun areProjectsCached(): Single<Boolean> {
        return projectsDatabase.cachedProjectsDao()
            .getProjects()
            .isEmpty
            .map { !it }
    }

    override fun setLastTimeCache(lastCache: Long): Completable {
        return Completable.defer {
            projectsDatabase.configDao().insertConfig(
                Config(lastCache)
            )
            Completable.complete()
        }
    }

    override fun isProjectCacheExpired(): Single<Boolean> {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()
        return projectsDatabase.configDao().getConfig()
            .single(Config(0))
            .map {
                currentTime - it.lastCacheTime > expirationTime
            }
    }
}