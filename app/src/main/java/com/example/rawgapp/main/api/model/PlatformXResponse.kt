package com.example.rawgapp.main.api.model


import com.google.gson.annotations.SerializedName

data class PlatformXResponse(
    @SerializedName("platform")
    val platform: PlatformResponse
)