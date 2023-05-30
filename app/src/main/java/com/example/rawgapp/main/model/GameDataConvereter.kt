package com.example.rawgapp.main.model

import com.example.rawgapp.main.api.model.GamesResponse

object GameDataConvereter {
    fun fromNetwork(response: GamesResponse) = response.results.map { gamesResponse ->
        GameModel(
            added = gamesResponse.added,
            backgroundImage = gamesResponse.backgroundImage,
            dominantColor = gamesResponse.dominantColor,
            id = gamesResponse.id,
            metacritic = gamesResponse.metacritic,
            name = gamesResponse.name,
            playtime = gamesResponse.playtime,
            rating = gamesResponse.rating,
            ratingTop = gamesResponse.ratingTop,
            ratingsCount = gamesResponse.ratingsCount,
            released = gamesResponse.released,
            reviewsCount = gamesResponse.reviewsCount,
            reviewsTextCount = gamesResponse.reviewsTextCount,
            saturatedColor = gamesResponse.saturatedColor,
            slug = gamesResponse.slug,
            suggestionsCount = gamesResponse.suggestionsCount,
            tba = gamesResponse.tba,
            updated = gamesResponse.updated
        )
    }
}