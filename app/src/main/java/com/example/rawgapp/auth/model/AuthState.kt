package com.example.rawgapp.auth.model

sealed interface AuthState {
    data class Success(val credentials: String) : AuthState

    data class Error(val e: Throwable) : AuthState
}