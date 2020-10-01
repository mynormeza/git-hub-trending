package com.mynormeza.mobile_ui.injection

import android.app.Application
import com.mynormeza.mobile_ui.GithubTrendingApplication
import com.mynormeza.mobile_ui.injection.module.*
import com.mynormeza.mobile_ui.injection.module.cache.CacheModule
import com.mynormeza.mobile_ui.injection.module.remote.RemoteModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    UiModule::class,
    PresentationModule::class,
    DataModule::class,
    CacheModule::class,
    RemoteModule::class
])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: GithubTrendingApplication)
}