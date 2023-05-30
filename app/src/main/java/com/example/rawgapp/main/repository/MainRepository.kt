package com.example.rawgapp.main.repository

import com.example.rawgapp.main.model.GameModel

interface MainRepository {
    suspend fun getGames(page: Int): List<GameModel>
}