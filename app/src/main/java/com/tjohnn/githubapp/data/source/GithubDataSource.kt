package com.tjohnn.githubapp.data.source

import com.tjohnn.githubapp.data.dto.ListResponse
import com.tjohnn.githubapp.data.dto.Repo
import io.reactivex.Single

interface GithubDataSource {
    fun searchReposByName(search: String, page: Int) : Single<ListResponse<Repo>>
}