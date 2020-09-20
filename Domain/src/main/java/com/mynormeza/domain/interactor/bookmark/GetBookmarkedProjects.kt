package com.mynormeza.domain.interactor.bookmark

import com.mynormeza.domain.executor.PostExecutionThread
import com.mynormeza.domain.interactor.ObservableUseCase
import com.mynormeza.domain.model.Project
import com.mynormeza.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetBookmarkedProjects @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<Project>, Nothing?>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }
}