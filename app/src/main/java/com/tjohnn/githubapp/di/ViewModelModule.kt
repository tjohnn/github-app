package com.tjohnn.githubapp.di

import com.tjohnn.githubapp.ui.search.SearchViewModel
import com.tjohnn.githubapp.utils.AppSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchViewModel(get(), get(), get()) }

    single { AppSchedulers() }
}