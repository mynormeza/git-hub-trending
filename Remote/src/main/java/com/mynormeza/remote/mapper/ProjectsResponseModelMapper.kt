package com.mynormeza.remote.mapper

import com.mynormeza.data.model.ProjectEntity
import com.mynormeza.remote.model.ProjectModel
import javax.inject.Inject

open class ProjectsResponseModelMapper @Inject constructor() : ModelMapper<ProjectModel, ProjectEntity> {
    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullName, model.starCount.toString(),
            model.dateCreated, model.ownerModel.ownerName, model.ownerModel.avatarUrl)
    }
}