package com.mynormeza.data.store

import com.mynormeza.data.model.ProjectEntity
import com.mynormeza.data.repository.ProjectsDataStore
import com.mynormeza.data.repository.ProjectsRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import java.lang.UnsupportedOperationException
import javax.inject.Inject

open class ProjectsRemoteDataStore @Inject constructor(
    private val projectsRemote: ProjectsRemote
): ProjectsDataStore {
    override fun getProjects(): Flowable<List<ProjectEntity>> {
        return projectsRemote.getProjects()
    }

    override fun getBookmarkedProjects(): Flowable<List<ProjectEntity>> {
        throw UnsupportedOperationException("Get bookmarked projects is not supported by this class")
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Set project as bookmark is not supported by this class")
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Set project as not bookmark is not supported by this class")
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        throw UnsupportedOperationException("Saving projects is not supported by this class")
    }

    override fun clearProjects(): Completable {
        throw UnsupportedOperationException("Clear projects is not supported by this class")
    }
}