package com.mynormeza.cache.model

import androidx.room.Entity

@Entity(tableName = "config")
class Config(val lastCacheTime: Long)