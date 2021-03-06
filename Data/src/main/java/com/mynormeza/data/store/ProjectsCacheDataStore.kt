package com.mynormeza.data.store

import com.mynormeza.data.model.ProjectEntity
import com.mynormeza.data.repository.ProjectsCache
import com.mynormeza.data.repository.ProjectsDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

open class ProjectsCacheDataStore @Inject constructor(
    private val projectsCache: ProjectsCache
): ProjectsDataStore {
    override fun getProjects(): Flowable<List<ProjectEntity>> {
        return projectsCache.getProjects()
    }

    override fun getBookmarkedProjects(): Flowable<List<ProjectEntity>> {
        return projectsCache.getBookmarkedProjects()
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsBookmarked(projectId)
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsNotBookmarked(projectId)
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        return projectsCache.saveProjects(projects).andThen(
            projectsCache.setLastTimeCache(System.currentTimeMillis())
        )
    }

    override fun clearProjects(): Completable {
        return projectsCache.clearProjects()
    }

}