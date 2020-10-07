package com.mynormeza.mobile_ui.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mynormeza.mobile_ui.injection.ViewModelFactory
import com.mynormeza.mobile_ui.injection.ViewModelKey
import com.mynormeza.presentation.BrowseBookmarkedProjectsViewModel
import com.mynormeza.presentation.BrowseProjectsViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap

@InstallIn(ApplicationComponent::class)
@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(BrowseProjectsViewModel::class)
    abstract fun bindBrowseProjectsViewModel(viewModel: BrowseProjectsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrowseBookmarkedProjectsViewModel::class)
    abstract fun bindBrowseBookmarkedProjectsViewModel(
        viewModel: BrowseBookmarkedProjectsViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}