package com.mynormeza.mobile_ui.injection.module.cache

import com.mynormeza.cache.ProjectsCacheImpl
import com.mynormeza.data.repository.ProjectsCache
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module(includes = [DbModule::class])
abstract class CacheModule {

    @Binds
    abstract fun bindProjectsCache(projectsCache: ProjectsCacheImpl): ProjectsCache
}