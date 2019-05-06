package com.tjohnn.githubapp.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tjohnn.githubapp.R
import com.tjohnn.githubapp.data.dto.Repo
import kotlinx.android.synthetic.main.list_item_repo.view.*

class ReposAdapter: RecyclerView.Adapter<ReposAdapter.RepoViewHolder>() {

    var items = mutableListOf<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    fun updateItems(repos: MutableList<Repo>) {
        items = repos
        notifyDataSetChanged()
    }


    class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindData(repo: Repo){
            itemView.name.text = repo.name
            itemView.description.text = repo.description
            itemView.stars.text = "${repo.stargazersCount}"
            itemView.watchers.text = "${repo.watchersCount}"
        }
    }

}
