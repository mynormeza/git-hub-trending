package com.mynormeza.cache.mapper

import com.mynormeza.cache.model.CachedProject
import com.mynormeza.data.model.ProjectEntity
import javax.inject.Inject

class CachedProjectMapper @Inject constructor(): CacheMapper<CachedProject, ProjectEntity> {
    override fun mapFromCache(type: CachedProject): ProjectEntity {
        return ProjectEntity(type.id, type.name, type.fullName,
            type.starCount, type.dateCreated, type.ownerName,
            type.ownerAvatar, type.isBookmarked)
    }

    override fun mapToCache(type: ProjectEntity): CachedProject {
        return CachedProject(type.id, type.name, type.fullName,
            type.starCount, type.dateCreated, type.ownerName,
            type.ownerAvatar, type.isBookmarked)
    }
}