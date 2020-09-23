package com.mynormeza.cache.mapper

import com.mynormeza.cache.model.CachedProject
import com.mynormeza.data.model.ProjectEntity

class CachedProjectMapper: CacheMapper<CachedProject, ProjectEntity> {
    override fun mapFromCache(cachedProject: CachedProject): ProjectEntity {
        return ProjectEntity(cachedProject.id, cachedProject.name, cachedProject.fullName,
            cachedProject.starCount, cachedProject.dateCreated, cachedProject.ownerName,
            cachedProject.ownerAvatar, cachedProject.isBookmarked)
    }

    override fun mapToCache(projectEntity: ProjectEntity): CachedProject {
        return CachedProject(projectEntity.id, projectEntity.name, projectEntity.fullName,
            projectEntity.starCount, projectEntity.dateCreated, projectEntity.ownerName,
            projectEntity.ownerAvatar, projectEntity.isBookmarked)
    }
}