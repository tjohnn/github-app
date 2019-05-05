package com.tjohnn.githubapp.data.dto

data class Repo (
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String,
    val language: String,
    val url: String,
    val htmlUrl: String,
    val forksCount: Int,
    val watchersCount: Int,
    val stargazersCount: Int,
    val owner: Owner
)

data class Owner (
    val login: String,
    val id: Long,
    val avatarUrl: String,
    val url: String,
    val type: String
)