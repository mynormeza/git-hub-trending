package com.mynormeza.data.repository

import com.mynormeza.data.model.ProjectEntity
import io.reactivex.Observable

interface ProjectsRemote {
    fun getProjects(): Observable<List<ProjectEntity>>
}