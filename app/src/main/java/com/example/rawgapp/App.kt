package com.example.rawgapp

import android.app.Application
import com.example.rawgapp.auth.AuthModule
import com.example.rawgapp.common.di.CommonModule
import com.example.rawgapp.game.GamesModule
import com.example.rawgapp.root.RootModule
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
        FirebaseApp.initializeApp(this)
    }

    private fun setupKoin() {
        stopKoin()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    CommonModule.create(),
                    GamesModule.create(),
                    RootModule.create(),
                    AuthModule.create()
                )
            )
        }
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}