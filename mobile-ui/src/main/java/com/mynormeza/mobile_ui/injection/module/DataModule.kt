package com.mynormeza.mobile_ui.injection.module

import com.mynormeza.data.ProjectsDataRepository
import com.mynormeza.domain.repository.ProjectsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository): ProjectsRepository
}