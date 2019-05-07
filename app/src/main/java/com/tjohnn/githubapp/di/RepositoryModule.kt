package com.tjohnn.githubapp.di

import com.tjohnn.githubapp.data.repo.GithubRepo
import com.tjohnn.githubapp.data.source.GithubDataSource
import com.tjohnn.githubapp.data.source.remote.RemoteGithubDataSource
import org.koin.dsl.module

val repoModule = module {
    single { RemoteGithubDataSource(get()) as GithubDataSource }
    single { GithubRepo(get()) }
}