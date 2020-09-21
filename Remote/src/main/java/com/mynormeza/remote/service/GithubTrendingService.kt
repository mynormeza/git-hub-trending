package com.mynormeza.remote.service

import com.mynormeza.remote.model.ProjectsResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubTrendingService {
    @GET("search")
    fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sortBy: String,
        @Query("order") order: String
    ): Observable<ProjectsResponseModel>
}