package com.tjohnn.githubapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.tjohnn.githubapp.R
import kotlinx.android.synthetic.main.fragment_search.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment: Fragment() {

    private val mViewModel by viewModel<SearchViewModel>()
    private lateinit var listAdapter: ReposAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        subscribeToViewModel()

        view.search.setOnEditorActionListener{ _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                mViewModel.searchRepoByName(view.search.text.toString())
                return@setOnEditorActionListener true
            }
            false
        }
    }

    private fun subscribeToViewModel() {
        mViewModel.getRepos().observe(this, Observer {
            if(it != null){
                listAdapter.updateItems(it)
            }
        })

        mViewModel.getIsLoading().observe(this, Observer {
            view?.progressBar?.visibility =
                if(it?.getContentIfNotHandled() != null && it.peekContent() == true)
                    View.VISIBLE
                else
                    View.INVISIBLE

        })

        mViewModel.getSnackBarMessage().observe(this, Observer {
            if (it?.getContentIfNotHandled() != null){
                Snackbar.make(view!!, "${it.peekContent()}", Snackbar.LENGTH_LONG).show()
            }
        })
    }

    private fun setupAdapter() {
        listAdapter = ReposAdapter()
        view?.repoList?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.setHasFixedSize(true)

            it.adapter = listAdapter

        }
    }


    companion object {
        @JvmField
        val TAG = SearchFragment::class.java.canonicalName

        @JvmStatic
        fun newInstance() : SearchFragment{
            return SearchFragment()
        }
    }
}