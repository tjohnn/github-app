package com.tjohnn.githubapp

import com.tjohnn.githubapp.data.dto.ListResponse
import com.tjohnn.githubapp.data.dto.Repo

internal fun getReposList(): ListResponse<Repo> {
    val list = arrayListOf<Repo>(
        Repo(1, "githubapp", "tjohnn/githubapp", "Simple git app", "kotlin", ""),
        Repo(2, "githubapp", "tjohnn/githubapp", "Simple git app", "kotlin", ""),
        Repo(3, "githubapp", "tjohnn/githubapp", "Simple git app", "kotlin", "")
    )
    return ListResponse("", "", list)
}