package com.tjohnn.githubapp.data.dto

data class SingleResponse<T> (
    val message: String,
    val status: String,
    val result: T
)