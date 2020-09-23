package com.mynormeza.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mynormeza.domain.interactor.bookmark.BookmarkProject
import com.mynormeza.domain.interactor.bookmark.UnbookmarkProject
import com.mynormeza.domain.interactor.browse.GetProjects
import com.mynormeza.domain.model.Project
import com.mynormeza.presentation.mapper.ProjectViewMapper
import com.mynormeza.presentation.model.ProjectView
import com.mynormeza.presentation.state.Resource
import com.mynormeza.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

open class BrowseProjectsViewModel @Inject internal constructor(
    private val getProjects: GetProjects?,
    private val bookmarkProject: BookmarkProject,
    private val unBookmarkProject: UnbookmarkProject,
    private val mapper: ProjectViewMapper
): ViewModel() {

    private val _liveData: MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    val projects: LiveData<Resource<List<ProjectView>>>
        get() = _liveData

    override fun onCleared() {
        getProjects?.dispose()
        super.onCleared()
    }

    fun fetchProjects() {
        _liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getProjects?.execute(ProjectsSubscriber())
    }

    fun bookmarkProject(projectId: String) {
        _liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return bookmarkProject.execute(BookmarkProjectsSubscriber(),
            BookmarkProject.Params.forProject(projectId))
    }

    fun unbookmarkProject(projectId: String) {
        _liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return unBookmarkProject.execute(BookmarkProjectsSubscriber(),
            UnbookmarkProject.Params.forProject(projectId))
    }

    inner class ProjectsSubscriber: DisposableObserver<List<Project>>() {
        override fun onNext(t: List<Project>) {
            _liveData.postValue(
                Resource(ResourceState.SUCCESS, t.map { mapper.mapToView(it) }, null)
            )
        }

        override fun onComplete() { }

        override fun onError(e: Throwable) {
            _liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }

    }

    inner class BookmarkProjectsSubscriber: DisposableCompletableObserver() {
        override fun onComplete() {
            _liveData.postValue(Resource(ResourceState.SUCCESS, _liveData.value?.data, null))
        }

        override fun onError(e: Throwable) {
            _liveData.postValue(
                Resource(ResourceState.ERROR, _liveData.value?.data, e.localizedMessage)
            )
        }

    }
}