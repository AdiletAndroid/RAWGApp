package com.example.rawgapp.main.repository

import com.example.rawgapp.main.model.GameModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getGames(page: Int): Flow<List<GameModel>>
}