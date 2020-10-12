package com.mynormeza.mobile_ui.injection.module

import com.mynormeza.domain.executor.PostExecutionThread
import com.mynormeza.mobile_ui.UiThread
import dagger.Binds
import dagger.Module

import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

}