package com.tjohnn.githubapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tjohnn.githubapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment: Fragment() {

    private val searchViewModel by viewModel<SearchViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {

    }

    private fun setupAdapter() {

    }


    companion object {
        @JvmField
        val  TAG = SearchFragment::class.java.canonicalName

        @JvmStatic
        fun newInstance() : SearchFragment{
            return SearchFragment()
        }
    }
}