package com.example.rawgapp.root

import com.example.rawgapp.common.di.InjectionModule
import com.example.rawgapp.root.ui.RootContract
import com.example.rawgapp.root.ui.RootPresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

object RootModule : InjectionModule {

    override fun create() = module {

        factoryOf(::RootPresenter) bind RootContract.Presenter::class
    }
}