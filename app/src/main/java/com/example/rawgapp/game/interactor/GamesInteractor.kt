package com.example.rawgapp.game.interactor

import com.example.rawgapp.game.model.GameModel
import com.example.rawgapp.game.repository.GamesRepository

class GamesInteractor(
    private val repository: GamesRepository
) {
    suspend fun getGames(page: Int): List<GameModel> {
        return repository.getGames(page)
    }
}