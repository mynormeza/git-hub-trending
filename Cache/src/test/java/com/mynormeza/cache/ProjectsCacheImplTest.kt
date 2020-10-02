package com.mynormeza.cache

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.mynormeza.cache.db.ProjectsDatabase
import com.mynormeza.cache.mapper.CachedProjectMapper
import com.mynormeza.cache.test.factory.ProjectDataFactory
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import androidx.test.core.app.ApplicationProvider
import io.reactivex.observers.TestObserver
import org.robolectric.annotation.Config

//TODO: Fix tests
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P], manifest = Config.NONE)
class ProjectsCacheImplTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
        ApplicationProvider.getApplicationContext(),
        ProjectsDatabase::class.java)
        .allowMainThreadQueries()
        .build()
    private val entityMapper = CachedProjectMapper()
    private val cache = ProjectsCacheImpl(database, entityMapper)

    @Test
    fun clearTablesCompletes() {
        val testObserver = cache.clearProjects().test()
        testObserver.assertComplete()
    }

    @Test
    fun saveProjectsCompletes() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())

        val testObserver = cache.saveProjects(projects).test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsReturnsData() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())
        cache.saveProjects(projects).test()

        val testObserver = cache.getProjects().test()
        testObserver.assertValueCount(1)
    }

    @Test
    fun getBookmarkedProjectsReturnsData() {
        val bookmarkedProject = ProjectDataFactory.makeBookmarkedProjectEntity()
        val projects = listOf(ProjectDataFactory.makeProjectEntity(), bookmarkedProject)
        cache.saveProjects(projects).test()

        val testObserver = cache.getBookmarkedProjects().test()
        testObserver.assertValueCount(1)
    }

    @Test
    fun setProjectAsBookmarkedCompletes() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())
        cache.saveProjects(projects).test()

        val testObserver = cache.setProjectAsBookmarked(projects[0].id).test()
        testObserver.assertComplete()
    }

    @Test
    fun setProjectAsNotBookmarkedCompletes() {
        val projects = listOf(ProjectDataFactory.makeBookmarkedProjectEntity())
        cache.saveProjects(projects).test()

        val testObserver = cache.setProjectAsNotBookmarked(projects[0].id).test()
        testObserver.assertComplete()
    }

    @Test
    fun areProjectsCacheReturnsData() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())
        cache.saveProjects(projects).test()

        val testObserver = cache.areProjectsCached().test()
        testObserver.assertValue(true)
    }

    @Test
    fun setLastCacheTimeCompletes() {
        val testObserver = cache.setLastTimeCache(1000L).test()
        testObserver.assertComplete()
    }

    @Test
    fun isProjectsCacheExpiredReturnsNotExpired() {
        cache.setLastTimeCache(System.currentTimeMillis() - 1000).test()
        val testObserver: TestObserver<Boolean> = cache.isProjectCacheExpired().test()
        testObserver.assertComplete()
    }

    @Test
    fun isProjectsCacheExpiredReturnsExpired() {
        val testObserver = cache.isProjectCacheExpired().test()
        testObserver.assertValue(true)
    }

}