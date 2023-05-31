package com.example.rawgapp.main.model

import com.example.rawgapp.main.api.model.GamesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object GameDataConvereter {
    fun fromNetwork(response: Flow<GamesResponse>): Flow<List<GameModel>> {
        return response.map { gamesResponse ->
            gamesResponse.results.map { gameResponse ->
                GameModel(
                    added = gameResponse.added,
                    backgroundImage = gameResponse.backgroundImage,
                    dominantColor = gameResponse.dominantColor,
                    id = gameResponse.id,
                    metacritic = gameResponse.metacritic,
                    name = gameResponse.name,
                    playtime = gameResponse.playtime,
                    rating = gameResponse.rating,
                    ratingTop = gameResponse.ratingTop,
                    ratingsCount = gameResponse.ratingsCount,
                    released = gameResponse.released,
                    reviewsCount = gameResponse.reviewsCount,
                    reviewsTextCount = gameResponse.reviewsTextCount,
                    saturatedColor = gameResponse.saturatedColor,
                    slug = gameResponse.slug,
                    suggestionsCount = gameResponse.suggestionsCount,
                    tba = gameResponse.tba,
                    updated = gameResponse.updated
                )
            }
        }
    }
}
