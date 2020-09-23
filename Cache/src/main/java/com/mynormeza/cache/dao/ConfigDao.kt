package com.mynormeza.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mynormeza.cache.model.Config
import io.reactivex.Flowable

@Dao
interface ConfigDao {
    @Query("SELECT * FROM config")
    fun getConfig(): Flowable<Config>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertConfig(config: Config)
}