package com.mynormeza.mobile_ui.ui.browse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mynormeza.mobile_ui.R
import com.mynormeza.mobile_ui.injection.ViewModelFactory
import com.mynormeza.mobile_ui.mapper.ProjectViewMapper
import com.mynormeza.mobile_ui.model.Project
import com.mynormeza.mobile_ui.ui.bookmarked.BookmarkedActivity
import com.mynormeza.presentation.BrowseProjectsViewModel
import com.mynormeza.presentation.model.ProjectView
import com.mynormeza.presentation.state.Resource
import com.mynormeza.presentation.state.ResourceState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_browse.*
import javax.inject.Inject

@AndroidEntryPoint
class BrowseActivity : AppCompatActivity() {
    @Inject lateinit var browseAdapter: BrowseAdapter
    @Inject lateinit var mapper: ProjectViewMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory
    @VisibleForTesting lateinit var browseViewModel: BrowseProjectsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)

        browseViewModel = ViewModelProvider(this, viewModelFactory)
            .get(BrowseProjectsViewModel::class.java)

        setupBrowseRecycler()
    }

    override fun onStart() {
        super.onStart()
        browseViewModel.projects.observe(this,
            Observer<Resource<List<ProjectView>>> {
                it?.let {
                    handleDataState(it)
                }
            })
        browseViewModel.fetchProjects()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_bookmarked -> {
                startActivity(BookmarkedActivity.getStartIntent(this))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupBrowseRecycler() {
        browseAdapter.projectListener = projectListener
        recycler_projects.layoutManager = LinearLayoutManager(this)
        recycler_projects.adapter = browseAdapter
    }

    private fun handleDataState(resource: Resource<List<ProjectView>>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setupScreenForSuccess(resource.data?.map {
                    mapper.mapToView(it)
                })
            }
            ResourceState.LOADING -> {
                progress.visibility = View.VISIBLE
                recycler_projects.visibility = View.GONE
            }
        }
    }

    private fun setupScreenForSuccess(projects: List<Project>?) {
        progress.visibility = View.GONE
        projects?.let {
            browseAdapter.projects = it
            browseAdapter.notifyDataSetChanged()
            recycler_projects.visibility = View.VISIBLE
        } ?: run {

        }
    }

    private val projectListener = object : ProjectListener {
        override fun onBookmarkedProjectClicked(projectId: String) {
            browseViewModel.unbookmarkProject(projectId)
        }

        override fun onProjectClicked(projectId: String) {
            browseViewModel.bookmarkProject(projectId)
        }
    }

}