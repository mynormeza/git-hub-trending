package com.mynormeza.mobile_ui.injection.module.cache

import com.mynormeza.cache.ProjectsCacheImpl
import com.mynormeza.data.repository.ProjectsCache
import dagger.Binds
import dagger.Module

@Module(includes = [DbModule::class])
abstract class CacheModule {

    @Binds
    abstract fun bindProjectsCache(projectsCache: ProjectsCacheImpl): ProjectsCache
}