package com.mynormeza.remote

import com.mynormeza.data.model.ProjectEntity
import com.mynormeza.data.repository.ProjectsRemote
import com.mynormeza.remote.mapper.ProjectsResponseModelMapper
import com.mynormeza.remote.service.GithubTrendingService
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
    private val service: GithubTrendingService,
    private val mapper: ProjectsResponseModelMapper
): ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("languaje:kotlin", "stars", "desc")
            .map {
                it.items.map {
                    mapper.mapFromModel(it) }
            }
    }
}