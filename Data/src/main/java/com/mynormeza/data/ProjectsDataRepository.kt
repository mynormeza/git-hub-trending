package com.mynormeza.data

import com.mynormeza.data.mapper.ProjectMapper
import com.mynormeza.data.repository.ProjectsCache
import com.mynormeza.data.store.ProjectsDataStoreFactory
import com.mynormeza.domain.model.Project
import com.mynormeza.domain.repository.ProjectsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

open class ProjectsDataRepository @Inject constructor(
    private val mapper: ProjectMapper,
    private val cache: ProjectsCache,
    private val factory: ProjectsDataStoreFactory
) : ProjectsRepository {

    override fun getProjects(): Observable<List<Project>> {
        return Observable.zip(
            cache.areProjectsCached().toObservable(),
            cache.isProjectCacheExpired().toObservable(),
            { areCached, isExpired ->
                Pair(areCached,isExpired)
            }
        ).flatMap {
            factory.getDataStore(it.first, it.second).getProjects().toObservable().distinctUntilChanged()
        }.flatMap {
            projects -> factory.getCacheDataStore()
            .saveProjects(projects)
            .andThen(Observable.just(projects))
        }.map {
            it.map {
                mapper.mapFromEntity(it)
            }
        }
    }

    override fun bookmarkProject(projectId: String): Completable {
        return factory.getCacheDataStore().setProjectAsBookmarked(projectId)
    }

    override fun unbookmarkProject(projectId: String): Completable {
        return factory.getCacheDataStore().setProjectAsNotBookmarked(projectId)
    }

    override fun getBookmarkedProjects(): Observable<List<Project>> {
        return factory.getCacheDataStore().getBookmarkedProjects().toObservable()
            .map {
                it.map {
                    mapper.mapFromEntity(it)
                }
            }
    }
}