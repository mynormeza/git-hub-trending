package com.mynormeza.presentation.bookmarked

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mynormeza.domain.interactor.bookmark.GetBookmarkedProjects
import com.mynormeza.domain.model.Project
import com.mynormeza.presentation.BrowseBookmarkedProjectsViewModel
import com.mynormeza.presentation.mapper.ProjectViewMapper
import com.mynormeza.presentation.model.ProjectView
import com.mynormeza.presentation.state.ResourceState
import com.mynormeza.presentation.test.factory.DataFactory
import com.mynormeza.presentation.test.factory.ProjectFactory
import com.nhaarman.mockitokotlin2.*
import io.reactivex.observers.DisposableObserver
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor

@RunWith(JUnit4::class)
class BrowseBookmarkedProjectsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    var getBookmarkedProjects = mock<GetBookmarkedProjects>()
    var mapper = mock<ProjectViewMapper>()
    var projectViewModel = BrowseBookmarkedProjectsViewModel(
        getBookmarkedProjects, mapper)

    @Captor
    val captor = argumentCaptor<DisposableObserver<List<Project>>>()

    @Test
    fun fetchProjectsExecutesUseCase() {
        projectViewModel.fetchProjects()

        verify(getBookmarkedProjects, times(1)).execute(any(), eq(null))
    }

    @Test
    fun fetchProjectsReturnsSuccess() {
        val projects = ProjectFactory.makeProjectList(2)
        val projectViews = ProjectFactory.makeProjectViewList(2)
        stubProjectMapperMapToView(projectViews[0], projects[0])
        stubProjectMapperMapToView(projectViews[1], projects[1])

        projectViewModel.fetchProjects()

        verify(getBookmarkedProjects).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(projects)

        assertEquals(
            ResourceState.SUCCESS,
            projectViewModel.projects.value?.status
        )
    }

    @Test
    fun fetchProjectsReturnsData() {
        val projects = ProjectFactory.makeProjectList(2)
        val projectViews = ProjectFactory.makeProjectViewList(2)
        stubProjectMapperMapToView(projectViews[0], projects[0])
        stubProjectMapperMapToView(projectViews[1], projects[1])

        projectViewModel.fetchProjects()

        verify(getBookmarkedProjects).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(projects)

        assertEquals(projectViews,
            projectViewModel.projects.value?.data
        )
    }

    @Test
    fun fetchProjectsReturnsError() {
        projectViewModel.fetchProjects()

        verify(getBookmarkedProjects).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())

        assertEquals(ResourceState.ERROR,
            projectViewModel.projects.value?.status)
    }

    @Test
    fun fetchProjectsReturnsMessageForError() {
        val errorMessage = DataFactory.randomString()
        projectViewModel.fetchProjects()

        verify(getBookmarkedProjects).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException(errorMessage))

        assertEquals(errorMessage,
            projectViewModel.projects.value?.message)
    }

    private fun stubProjectMapperMapToView(projectView: ProjectView, project: Project) {
        whenever(mapper.mapToView(project))
            .thenReturn(projectView)
    }

}