package com.tjohnn.githubapp.data.source.remote

import com.tjohnn.githubapp.data.dto.ListResponse
import com.tjohnn.githubapp.data.dto.Repo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    fun searchRepos(@Query("page") page: Int, @Query("q") search: String): Single<ListResponse<Repo>>

}