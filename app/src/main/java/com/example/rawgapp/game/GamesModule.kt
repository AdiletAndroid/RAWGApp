package com.example.rawgapp.game

import com.example.rawgapp.common.di.InjectionModule
import com.example.rawgapp.game.interactor.GamesInteractor
import com.example.rawgapp.game.repository.GamesRemoteRepository
import com.example.rawgapp.game.repository.GamesRepository
import com.example.rawgapp.game.ui.GamesContract
import com.example.rawgapp.game.ui.GamesPresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object GamesModule : InjectionModule {
    override fun create() = module {

        singleOf(::GamesRemoteRepository) bind GamesRepository::class

        factoryOf(::GamesInteractor)

        factoryOf(::GamesPresenter) bind GamesContract.Presenter::class
    }
}

