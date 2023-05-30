package com.example.rawgapp

import android.app.Application
import com.example.rawgapp.common.di.CommonModule
import com.example.rawgapp.main.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupKoin() {
        stopKoin()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    CommonModule.create(),
                    MainModule.create()
                )
            )
        }
    }

    private fun setupTimber(){
        Timber.plant(Timber.DebugTree())
    }
}