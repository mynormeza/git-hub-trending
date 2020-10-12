package com.mynormeza.data.repository

import com.mynormeza.data.model.ProjectEntity
import io.reactivex.Flowable
import io.reactivex.Observable

interface ProjectsRemote {
    fun getProjects(): Flowable<List<ProjectEntity>>
}