package com.mynormeza.mobile_ui.injection

import com.mynormeza.data.repository.ProjectsRemote
import com.mynormeza.mobile_ui.injection.module.remote.RemoteModule
import com.mynormeza.remote.service.GithubTrendingService
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
object TestRemoteModule {

    @Provides
    fun provideGithubService(): GithubTrendingService {
        return mock()
    }

    @Provides
    fun provideProjectsRemote(): ProjectsRemote {
        return mock()
    }

}