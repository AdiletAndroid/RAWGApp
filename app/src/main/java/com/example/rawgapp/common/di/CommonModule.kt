package com.example.rawgapp.common.di

import com.example.rawgapp.main.api.MainPageApi
import com.example.rawgapp.utils.constants.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommonModule : InjectionModule {
    override fun create() = module {
        single {
            Retrofit.Builder().baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(MainPageApi::class.java)
        }
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }
    }
}