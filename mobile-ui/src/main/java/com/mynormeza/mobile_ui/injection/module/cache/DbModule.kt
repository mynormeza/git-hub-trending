package com.mynormeza.mobile_ui.injection.module.cache

import android.app.Application
import com.mynormeza.cache.db.ProjectsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@DisableInstallInCheck
@Module
object DbModule {
    @Provides
    fun providesDataBase(application: Application): ProjectsDatabase {
        return ProjectsDatabase.getInstance(application)
    }
}