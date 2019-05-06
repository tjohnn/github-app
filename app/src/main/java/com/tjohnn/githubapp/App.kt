package com.tjohnn.githubapp

import android.app.Application
import com.tjohnn.githubapp.di.networkModule
import com.tjohnn.githubapp.di.repoModule
import com.tjohnn.githubapp.di.viewModelModule
import com.tjohnn.githubapp.utils.TimberTree
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(viewModelModule, networkModule, repoModule)
        }

        if (BuildConfig.DEBUG)
            Timber.plant(TimberTree())

    }

}