package com.mynormeza.mobile_ui.injection.module

import com.mynormeza.domain.executor.PostExecutionThread
import com.mynormeza.mobile_ui.ui.browse.BrowseActivity
import com.mynormeza.mobile_ui.UiThread
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity(): BrowseActivity

//    @ContributesAndroidInjector
//    abstract fun contributesBookmarkedActivity(): BookmarkedActivity
}