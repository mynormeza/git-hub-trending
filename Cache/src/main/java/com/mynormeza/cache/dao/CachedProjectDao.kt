package com.mynormeza.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mynormeza.cache.model.CachedProject
import io.reactivex.Flowable

@Dao
abstract class CachedProjectDao {

    @Query("SELECT * FROM projects")
    abstract fun getProjects(): Flowable<List<CachedProject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProjects(projects: List<CachedProject>)

    @Query("DELETE FROM projects")
    abstract fun deleteProjects()

    @Query("SELECT * FROM projects WHERE is_bookmarked = 1")
    abstract fun getBookmarkedProjects(): Flowable<List<CachedProject>>

    @Query("UPDATE projects SET is_bookmarked = :isBookmarked WHERE project_id = :projectId")
    abstract fun setBookmarkStatus(isBookmarked: Boolean, projectId: String)
}