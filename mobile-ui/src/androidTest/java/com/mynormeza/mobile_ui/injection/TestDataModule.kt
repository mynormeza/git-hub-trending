package com.mynormeza.mobile_ui.injection

import com.mynormeza.domain.repository.ProjectsRepository
import com.mynormeza.mobile_ui.injection.module.DataModule
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class TestDataModule {

    @Provides
    fun provideDataRepository(): ProjectsRepository {
        return mock()
    }

}