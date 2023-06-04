package com.example.rawgapp.game.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameModel(
    val id: Int,
    val name: String,
    val backgroundImage: String,
    val rating: Double,
    val ratingTop: Float,
    val released: String,
    val shortScreenshots: List<String>,
    val slug: String,
    val tba: Boolean,
    val updated: String
): Parcelable