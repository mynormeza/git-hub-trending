package com.mynormeza.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "config")
data class Config(
    @PrimaryKey(autoGenerate = true) var id: Int = -1,
    val lastCacheTime: Long
)