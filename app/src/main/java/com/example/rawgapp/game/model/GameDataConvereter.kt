package com.example.rawgapp.game.model

import com.example.rawgapp.game.api.model.GamesResponse

object GameDataConvereter {
    fun fromNetwork(response: GamesResponse): List<GameModel> {
        return response.results.map { gameResponse ->
            GameModel(
                id = gameResponse.id,
                name = gameResponse.name,
                backgroundImage = gameResponse.backgroundImage,
                rating = gameResponse.rating,
                ratingTop = gameResponse.ratingTop,
                released = gameResponse.released,
                shortScreenshots = gameResponse.shortScreenshots.map { it.image },
                slug = gameResponse.slug,
                tba = gameResponse.tba,
                updated = gameResponse.updated
            )
        }
    }
}