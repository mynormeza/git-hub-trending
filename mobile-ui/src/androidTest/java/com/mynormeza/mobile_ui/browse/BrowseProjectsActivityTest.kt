package com.mynormeza.mobile_ui.browse

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mynormeza.domain.model.Project
import com.mynormeza.domain.repository.ProjectsRepository

import com.mynormeza.mobile_ui.R
import com.mynormeza.mobile_ui.injection.module.DataModule
import com.mynormeza.mobile_ui.test.factory.ProjectDataFactory
import com.mynormeza.mobile_ui.ui.browse.BrowseActivity
import com.mynormeza.mobile_ui.ui.browse.BrowseAdapter
import com.nhaarman.mockitokotlin2.whenever
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import javax.inject.Inject
import com.google.common.truth.Truth.assertThat

@HiltAndroidTest
class BrowseProjectsActivityTest {


    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun verifyInjection() {
        ActivityScenario.launch(BrowseActivity::class.java).use {
            it.moveToState(Lifecycle.State.CREATED)
            it.onActivity { activity ->
                assertThat(activity.browseViewModel).isNotNull()
                activity.browseViewModel.projects.observe(activity) { repos ->
                    assertThat(repos).isNotNull()
                }
            }
        }
    }
}
