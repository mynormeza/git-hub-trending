package com.mynormeza.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class CachedProject(
    @PrimaryKey @ColumnInfo(name = "project_id") val id: String,
    val name: String,
    val fullName: String,
    val starCount: String,
    val dateCreated: String,
    val ownerName: String,
    val ownerAvatar: String,
    @ColumnInfo(name = "is_bookmarked") var isBookmarked: Boolean
)
