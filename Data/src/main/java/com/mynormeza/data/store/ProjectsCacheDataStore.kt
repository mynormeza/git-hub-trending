package com.mynormeza.data.store

import com.mynormeza.data.model.ProjectEntity
import com.mynormeza.data.repository.ProjectsCache
import com.mynormeza.data.repository.ProjectsDataStore
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsCacheDataStore @Inject constructor(
    private val projectsCache: ProjectsCache
): ProjectsDataStore {
    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsCache.getProjects()
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        return projectsCache.getBookmarkedProjects()
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsBookmark(projectId)
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsNotBookmark(projectId)
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