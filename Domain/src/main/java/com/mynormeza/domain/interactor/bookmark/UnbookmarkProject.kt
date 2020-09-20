package com.mynormeza.domain.interactor.bookmark

import com.mynormeza.domain.executor.PostExecutionThread
import com.mynormeza.domain.interactor.CompletableUseCase
import com.mynormeza.domain.repository.ProjectsRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException
import javax.inject.Inject

open class UnbookmarkProject @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<UnbookmarkProject.Params>(postExecutionThread) {

    public override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params cannot be null")
        return projectsRepository.unbookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String): Params {
                return Params(projectId)
            }
        }
    }
}