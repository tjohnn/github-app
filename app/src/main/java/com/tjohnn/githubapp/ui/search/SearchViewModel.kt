package com.tjohnn.githubapp.ui.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tjohnn.githubapp.data.dto.Repo
import com.tjohnn.githubapp.data.repo.GithubRepo
import com.tjohnn.githubapp.utils.AppSchedulers
import com.tjohnn.githubapp.utils.EventWrapper
import io.reactivex.disposables.CompositeDisposable

class SearchViewModel(
    app: Application,
    private val schedulers: AppSchedulers,
    private val repo: GithubRepo
): AndroidViewModel(app) {

    private val compositeDisposable = CompositeDisposable()
    private val isLoading: MutableLiveData<EventWrapper<Boolean>> = MutableLiveData()
    private val snackBarMessage: MutableLiveData<EventWrapper<String>> = MutableLiveData()
    private val repos: MutableLiveData<MutableList<Repo>> = MutableLiveData()
    private var lastSearch = ""
    private var currentPage = 1

    fun searchRepoByName(search: String){
        if(search.isEmpty()) return

        currentPage = if(lastSearch == search) currentPage + 1 else 1

        lastSearch = search

        compositeDisposable.add(
            repo.searchRepository(search, currentPage)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.main())
                .doOnSubscribe { isLoading.postValue(EventWrapper(true)) }
                .doOnSuccess { isLoading.postValue(EventWrapper(false)) }
                .doOnError { isLoading.postValue(EventWrapper(false)) }
                .subscribe({
                    if (currentPage == 1) {
                        repos.value = it.results as MutableList<Repo>
                    } else {
                        val items = repos.value
                        items?.addAll(it.results)
                        repos.value = items
                    }
                }, {
                    snackBarMessage.value = EventWrapper(it.message)
                })
        )

    }

    fun getSnackBarMessage(): LiveData<EventWrapper<String>> = snackBarMessage
    fun getIsLoading(): LiveData<EventWrapper<Boolean>> = isLoading
    fun getRepos(): LiveData<MutableList<Repo>> = repos


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}