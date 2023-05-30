package com.example.rawgapp.main.repository

import com.example.rawgapp.main.api.MainPageApi
import com.example.rawgapp.main.model.GameDataConvereter
import com.example.rawgapp.main.model.GameModel
import com.example.rawgapp.utils.constants.Constants.API_KEY

class MainRemoteRepository(
    private val api: MainPageApi
) : MainRepository {
    override suspend fun getGames(page: Int): List<GameModel> {
        return GameDataConvereter.fromNetwork(api.getGames(page, "q", API_KEY))
    }
}