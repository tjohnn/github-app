package com.tjohnn.githubapp.data.dto

import com.google.gson.annotations.SerializedName

data class ListResponse<T> (
    val message: String,
    val status: String,
    @SerializedName(value = "data", alternate = ["results", "items"])
    val results: List<T>
)