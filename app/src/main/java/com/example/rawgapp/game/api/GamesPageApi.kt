package com.example.rawgapp.game.api

import com.example.rawgapp.game.api.model.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesPageApi {
    @GET("games")
    suspend fun getGames(
        @Query("key") apiKey: String,
        @Query("q") q: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): GamesResponse
}