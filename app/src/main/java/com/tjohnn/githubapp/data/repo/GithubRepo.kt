package com.tjohnn.githubapp.data.repo

import com.tjohnn.githubapp.data.source.GithubDataSource

class GithubRepo(private val dataSource: GithubDataSource) {

    fun searchRepository(search: String, page: Int) = dataSource.searchReposByName(search, page)

}