package com.mynormeza.cache.dao

import androidx.room.*
import com.mynormeza.cache.model.CachedProject
import io.reactivex.Flowable

@Dao
interface CachedProjectDao {

    @Query("SELECT * FROM projects")
    fun getProjects(): Flowable<List<CachedProject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProjects(projects: List<CachedProject>)

    @Query("DELETE FROM projects")
    fun deleteProjects()

    @Query("SELECT * FROM projects WHERE is_bookmarked = 1")
    fun getBookmarkedProjects(): Flowable<List<CachedProject>>

    @Query("UPDATE projects SET is_bookmarked = :isBookmarked WHERE project_id = :projectId")
    fun setBookmarkStatus(isBookmarked: Boolean, projectId: String)
}