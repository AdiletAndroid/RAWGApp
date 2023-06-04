package com.example.rawgapp.game.api.model


import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("rating_top")
    val ratingTop: Float,
    @SerializedName("released")
    val released: String,
    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshotResponse>,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("tba")
    val tba: Boolean,
    @SerializedName("updated")
    val updated: String
)