package com.mynormeza.mobile_ui.injection.module.remote

import com.mynormeza.data.repository.ProjectsRemote
import com.mynormeza.remote.ProjectsRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module(includes = [RetrofitModule::class])
abstract class RemoteModule {
    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote
}