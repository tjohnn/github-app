package com.tjohnn.githubapp.data.source.remote

import com.tjohnn.githubapp.data.source.GithubDataSource

class RemoteGithubDataSource(val apiService: ApiService) : GithubDataSource {

    override fun searchReposByName(search: String, page: Int) = apiService.searchRepos(page, search)

}