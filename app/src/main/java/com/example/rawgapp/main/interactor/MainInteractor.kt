package com.example.rawgapp.main.interactor

import com.example.rawgapp.main.model.GameModel
import com.example.rawgapp.main.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainInteractor(
    val repository: MainRepository
) {
    suspend fun getGamesFlow(page: Int): Flow<List<GameModel>> {
        return repository.getGames(page)
    }
}