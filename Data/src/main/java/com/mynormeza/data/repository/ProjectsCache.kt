package com.mynormeza.data.repository

import com.mynormeza.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface ProjectsCache {
    fun clearProjects(): Completable

    fun saveProjects(projects: List<ProjectEntity>): Completable

    fun getProjects(): Observable<List<ProjectEntity>>

    fun getBookmarkedProjects(): Observable<List<ProjectEntity>>

    fun setProjectAsBookmark(projectId: String): Completable

    fun setProjectAsNotBookmark(projectId: String): Completable

    fun areProjectsCached(): Single<Boolean>

    fun setLastTimeCache(lastCache: Long): Completable

    fun isProjectCacheExpired(): Single<Boolean>
}