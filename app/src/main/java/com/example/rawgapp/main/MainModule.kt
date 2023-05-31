package com.example.rawgapp.main

import com.example.rawgapp.common.di.InjectionModule
import com.example.rawgapp.main.interactor.MainInteractor
import com.example.rawgapp.main.repository.MainRemoteRepository
import com.example.rawgapp.main.repository.MainRepository
import com.example.rawgapp.main.ui.MainPageContract
import com.example.rawgapp.main.ui.MainPagePresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule : InjectionModule {
    override fun create() = module {

        singleOf(::MainRemoteRepository) bind MainRepository::class

        factoryOf(::MainInteractor)

        factoryOf(::MainPagePresenter) bind MainPageContract.Presenter::class
    }
}

