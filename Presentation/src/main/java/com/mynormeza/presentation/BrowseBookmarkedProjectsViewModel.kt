package com.mynormeza.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mynormeza.domain.interactor.bookmark.GetBookmarkedProjects
import com.mynormeza.domain.model.Project
import com.mynormeza.presentation.mapper.ProjectViewMapper
import com.mynormeza.presentation.model.ProjectView
import com.mynormeza.presentation.state.Resource
import com.mynormeza.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseBookmarkedProjectsViewModel @Inject constructor(
    private val getBookmarkedProjects: GetBookmarkedProjects,
    private val mapper: ProjectViewMapper
): ViewModel() {

    private val _liveData: MutableLiveData<Resource<List<ProjectView>>> =
        MutableLiveData()
    val projects: LiveData<Resource<List<ProjectView>>>
        get() = _liveData

    override fun onCleared() {
        getBookmarkedProjects.dispose()
        super.onCleared()
    }


    fun fetchProjects() {
        _liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getBookmarkedProjects.execute(ProjectsSubscriber())
    }

    inner class ProjectsSubscriber: DisposableObserver<List<Project>>() {
        override fun onNext(t: List<Project>) {
            _liveData.postValue(
                Resource(ResourceState.SUCCESS, t.map { mapper.mapToView(it) }, null)
            )
        }

        override fun onError(e: Throwable) {
            _liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }

        override fun onComplete() { }
    }
}