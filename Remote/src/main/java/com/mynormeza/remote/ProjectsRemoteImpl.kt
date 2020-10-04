package com.mynormeza.remote

import com.mynormeza.data.model.ProjectEntity
import com.mynormeza.data.repository.ProjectsRemote
import com.mynormeza.remote.mapper.ProjectsResponseModelMapper
import com.mynormeza.remote.service.GithubTrendingService
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
    private val service: GithubTrendingService,
    private val mapper: ProjectsResponseModelMapper
): ProjectsRemote {

    override fun getProjects(): Flowable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
            .map {
                it.items.map {
                    mapper.mapFromModel(it) }
            }
    }
}