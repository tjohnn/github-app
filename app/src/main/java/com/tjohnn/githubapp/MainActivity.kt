package com.tjohnn.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tjohnn.githubapp.ui.search.SearchFragment
import com.tjohnn.githubapp.utils.replaceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            replaceFragment(supportFragmentManager, SearchFragment.newInstance(), SearchFragment.TAG, R.id.content_main)
        }
    }
}
