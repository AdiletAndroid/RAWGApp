package com.example.rawgapp.main.api

import com.example.rawgapp.main.api.model.GamesResponse
import com.example.rawgapp.utils.constants.Constants.API_KEY
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface MainPageApi {
    @GET("/api/games?")
    suspend fun getGames(
        @Query("page") page: Int,
        @Query("q") query: String,
        @Query("api-key") apiKey: String = API_KEY
    ): Flow<GamesResponse>
}