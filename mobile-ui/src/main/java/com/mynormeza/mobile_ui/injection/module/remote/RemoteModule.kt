package com.mynormeza.mobile_ui.injection.module.remote

import com.mynormeza.data.repository.ProjectsRemote
import com.mynormeza.remote.ProjectsRemoteImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RetrofitModule::class])
abstract class RemoteModule {
    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote
}