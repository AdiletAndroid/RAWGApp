package com.example.rawgapp.game.repository

import com.example.rawgapp.game.model.GameModel

interface GamesRepository {
    suspend fun getGames(page: Int): List<GameModel>
}