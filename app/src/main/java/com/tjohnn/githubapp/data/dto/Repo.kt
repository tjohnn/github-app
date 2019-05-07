package com.tjohnn.githubapp.data.dto

data class Repo (
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String,
    val language: String,
    val url: String,
    val htmlUrl: String? = null,
    val forksCount: Int? = null,
    val watchersCount: Int? = null,
    val stargazersCount: Int? = null,
    val owner: Owner? = null
)

data class Owner (
    val login: String,
    val id: Long,
    val avatarUrl: String,
    val url: String,
    val type: String
)