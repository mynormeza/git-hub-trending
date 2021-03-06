package com.mynormeza.mobile_ui.browse

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import com.mynormeza.mobile_ui.ui.browse.BrowseActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
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
