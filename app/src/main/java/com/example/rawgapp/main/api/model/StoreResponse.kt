package com.example.rawgapp.main.api.model


import com.google.gson.annotations.SerializedName

data class StoreResponse(
    @SerializedName("store")
    val store: StoreXResponse
)