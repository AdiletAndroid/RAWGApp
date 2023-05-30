package com.example.rawgapp.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameModel(
    val added: Int,
    val backgroundImage: String,
    val dominantColor: String,
    val id: Int,
    val metacritic: Int,
    val name: String,
    val playtime: Int,
    val rating: Double,
    val ratingTop: Int,
    val ratingsCount: Int,
    val released: String,
    val reviewsCount: Int,
    val reviewsTextCount: Int,
    val saturatedColor: String,
    val slug: String,
    val suggestionsCount: Int,
    val tba: Boolean,
    val updated: String
): Parcelable