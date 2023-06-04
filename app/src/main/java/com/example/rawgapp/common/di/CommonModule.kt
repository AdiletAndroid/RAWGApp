package com.example.rawgapp.common.di

import android.content.Context
import com.example.rawgapp.game.api.GamesPageApi
import com.example.rawgapp.utils.constants.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val PREFS_NAME = "rawg.app.prefs"

object CommonModule : InjectionModule {

    override fun create() = module {
        single {
            Retrofit.Builder().baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(GamesPageApi::class.java)
        }
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }
        single { androidContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }
    }
}