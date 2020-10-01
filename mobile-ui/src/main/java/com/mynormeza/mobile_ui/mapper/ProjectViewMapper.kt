package com.mynormeza.mobile_ui.mapper

import com.mynormeza.mobile_ui.model.Project
import com.mynormeza.presentation.model.ProjectView
import javax.inject.Inject

class ProjectViewMapper @Inject constructor(): ViewMapper<ProjectView, Project> {

    override fun mapToView(type: ProjectView): Project {
        return Project(type.id, type.name,
            type.fullName, type.starCount,
            type.dateCreated, type.ownerName,
            type.ownerAvatar, type.isBookmarked,
        )
    }

}