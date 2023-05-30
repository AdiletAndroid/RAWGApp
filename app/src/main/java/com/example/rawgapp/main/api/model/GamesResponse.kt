package com.example.rawgapp.main.api.model


import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<ResultResponse>,
    @SerializedName("user_platforms")
    val userPlatforms: Boolean
)