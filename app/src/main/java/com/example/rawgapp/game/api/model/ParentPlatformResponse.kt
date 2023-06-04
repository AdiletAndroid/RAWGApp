package com.example.rawgapp.game.api.model


import com.google.gson.annotations.SerializedName

data class ParentPlatformResponse(
    @SerializedName("platform")
    val platform: PlatformResponse
)