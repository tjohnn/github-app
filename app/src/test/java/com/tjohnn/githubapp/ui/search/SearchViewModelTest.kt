package com.tjohnn.githubapp.ui.search

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tjohnn.githubapp.data.repo.GithubRepo
import com.tjohnn.githubapp.getReposList
import com.tjohnn.githubapp.utils.AppSchedulers
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class SearchViewModelTest {

    @Mock
    lateinit var repo: GithubRepo
    @Mock
    lateinit var application: Application
    @Mock
    lateinit var appSchedulers: AppSchedulers

    private lateinit var searchViewModel: SearchViewModel

    val SEARCH_TEXT = "githubapp"

    // Executes each mutable livedata task synchronously using Architecture Components.
    // resolves issue "Method getMainLooper in android.os.Looper not mocked"
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        searchViewModel = SearchViewModel(application, appSchedulers, repo)

        `when`(appSchedulers.io()).thenReturn(Schedulers.trampoline())
        `when`(appSchedulers.main()).thenReturn(Schedulers.trampoline())
        `when`(appSchedulers.computation()).thenReturn(Schedulers.trampoline())
    }

    @Test
    fun `searchRepoByName succeeds`() {
        val list = getReposList()
        `when`(repo.searchRepository(anyString(), anyInt())).thenReturn(Single.just(list))

        searchViewModel.searchRepoByName(SEARCH_TEXT)

        verify(repo).searchRepository(SEARCH_TEXT, 1)

        assertEquals(searchViewModel.getRepos().value, list.results)

    }

    @Test
    fun `searchRepoByName fails`() {
        val errorMessage = "Error"
        `when`(repo.searchRepository(anyString(), anyInt())).thenReturn(Single.error(Exception(errorMessage)))

        searchViewModel.searchRepoByName(SEARCH_TEXT)

        verify(repo).searchRepository(SEARCH_TEXT, 1)

        assertEquals(searchViewModel.getSnackBarMessage().value?.peekContent(), errorMessage)
    }
}