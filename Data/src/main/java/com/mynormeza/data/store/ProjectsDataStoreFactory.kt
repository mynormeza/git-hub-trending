package com.mynormeza.data.store

import com.mynormeza.data.repository.ProjectsDataStore
import javax.inject.Inject

open class ProjectsDataStoreFactory @Inject constructor(
    private val projectsCacheDataStore: ProjectsCacheDataStore,
    private val projectsRemoteDataStore: ProjectsRemoteDataStore
) {
    open fun getDataStore(projectsCached: Boolean, projectsCacheExpired: Boolean): ProjectsDataStore {
        return if (projectsCached && !projectsCacheExpired){
            projectsCacheDataStore
        } else {
            projectsRemoteDataStore
        }
    }

    open fun getCacheDataStore(): ProjectsDataStore {
        return projectsCacheDataStore
    }
}