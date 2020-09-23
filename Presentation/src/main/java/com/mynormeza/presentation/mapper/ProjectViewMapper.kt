package com.mynormeza.presentation.mapper

import com.mynormeza.domain.model.Project
import com.mynormeza.presentation.model.ProjectView
import javax.inject.Inject

class ProjectViewMapper @Inject constructor() : Mapper<ProjectView, Project> {

    override fun mapToView(type: Project): ProjectView {
        return ProjectView(type.id, type.name, type.fullName,
            type.starCount, type.dateCreated, type.ownerName,
            type.ownerAvatar, type.isBookmarked)
    }
}