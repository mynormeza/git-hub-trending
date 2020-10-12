package com.mynormeza.mobile_ui.injection

import android.app.Application
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.mynormeza.cache.db.ProjectsDatabase
import com.mynormeza.data.repository.ProjectsCache
import com.mynormeza.mobile_ui.injection.module.cache.CacheModule
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
object TestCacheModule {

    @Provides
    fun provideDatabase(application: Application): ProjectsDatabase {
        return Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ProjectsDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideProjectsCache(): ProjectsCache {
        return mock()
    }

}