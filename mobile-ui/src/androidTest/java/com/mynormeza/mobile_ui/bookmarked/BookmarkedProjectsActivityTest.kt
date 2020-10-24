package com.mynormeza.mobile_ui.bookmarked

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.mynormeza.mobile_ui.ui.bookmarked.BookmarkedActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class BookmarkedProjectsActivityTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)


    @Test
    fun verifyInjection() {
        ActivityScenario.launch(BookmarkedActivity::class.java).use {
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