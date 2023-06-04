package com.example.rawgapp.game.repository

import com.example.rawgapp.game.api.GamesPageApi
import com.example.rawgapp.game.model.GameDataConvereter
import com.example.rawgapp.game.model.GameModel
import com.example.rawgapp.utils.constants.Constants.API_KEY
import kotlinx.coroutines.flow.Flow

private const val PAGE_SIZE = 20

class GamesRemoteRepository(
    private val api: GamesPageApi
) : GamesRepository {
    override suspend fun getGames(page: Int): List<GameModel> {
        val response = api.getGames(API_KEY, "q", page, PAGE_SIZE)
        return GameDataConvereter.fromNetwork(response)
    }
}