package com.mynormeza.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mynormeza.cache.model.Config
import io.reactivex.Flowable

@Dao
abstract class ConfigDao {
    @Query("SELECT * FROM config LIMIT 1")
    abstract fun getConfig(): Flowable<List<Config>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertConfig(config: Config)
}