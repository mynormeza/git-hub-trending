package com.mynormeza.mobile_ui.injection.module.remote

import com.mynormeza.mobile_ui.BuildConfig
import com.mynormeza.remote.service.GithubTrendingService
import com.mynormeza.remote.service.GithubTrendingServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@DisableInstallInCheck
@Module
object RetrofitModule {
    @Provides
    fun provideGithubService(): GithubTrendingService {
        return GithubTrendingServiceFactory().makeGithubTrendingService(BuildConfig.DEBUG)
    }
}