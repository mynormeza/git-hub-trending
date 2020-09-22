package com.mynormeza.remote

import com.mynormeza.data.model.ProjectEntity
import com.mynormeza.remote.mapper.ProjectsResponseModelMapper
import com.mynormeza.remote.model.ProjectModel
import com.mynormeza.remote.model.ProjectsResponseModel
import com.mynormeza.remote.service.GithubTrendingService
import com.mynormeza.remote.test.factory.ProjectDataFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProjectsRemoteImplTest {

    private val mapper = mock<ProjectsResponseModelMapper>()
    private val service = mock<GithubTrendingService>()
    private val remote = ProjectsRemoteImpl(service, mapper)

    @Test
    fun getProjectsCompletes() {
        stubGithubTrendingServiceSearchRepositories(
            Observable.just(
            ProjectDataFactory.makeProjectsResponse())
        )
        stubProjectsResponseModelMapperMapFromModel(
            any(),
            ProjectDataFactory.makeProjectEntity()
        )

        val testObserver = remote.getProjects().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsCallsServer() {
        stubGithubTrendingServiceSearchRepositories(Observable.just(
            ProjectDataFactory.makeProjectsResponse())
        )
        stubProjectsResponseModelMapperMapFromModel(
            any(),
            ProjectDataFactory.makeProjectEntity()
        )

        remote.getProjects().test()
        verify(service).searchRepositories(any(), any(), any())
    }

    @Test
    fun getProjectsReturnsData() {
        val response = ProjectDataFactory.makeProjectsResponse()
        stubGithubTrendingServiceSearchRepositories(Observable.just(response))
        val entities = mutableListOf<ProjectEntity>()
        response.items.forEach {
            val entity = ProjectDataFactory.makeProjectEntity()
            entities.add(entity)
            stubProjectsResponseModelMapperMapFromModel(it, entity)
        }
        val testObserver = remote.getProjects().test()
        testObserver.assertValue(entities)
    }

    @Test
    fun getProjectsCallsServerWithCorrectParameters() {
        stubGithubTrendingServiceSearchRepositories(
            Observable.just(ProjectDataFactory.makeProjectsResponse())
        )
        stubProjectsResponseModelMapperMapFromModel(
            any(),
            ProjectDataFactory.makeProjectEntity()
        )

        remote.getProjects().test()
        verify(service).searchRepositories("language:kotlin", "stars", "desc")
    }

    private fun stubGithubTrendingServiceSearchRepositories(observable: Observable<ProjectsResponseModel>) {
        whenever(service.searchRepositories(any(), any(), any()))
            .thenReturn(observable)
    }

    private fun stubProjectsResponseModelMapperMapFromModel(model: ProjectModel, entity: ProjectEntity) {
        whenever(mapper.mapFromModel(model))
            .thenReturn(entity)
    }

}