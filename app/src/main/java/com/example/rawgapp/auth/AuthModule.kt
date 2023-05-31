package com.example.rawgapp.auth

import com.example.rawgapp.auth.interactor.AuthInteractor
import com.example.rawgapp.auth.repository.FirebaseRepository
import com.example.rawgapp.auth.ui.RegistrationContract
import com.example.rawgapp.auth.ui.RegistrationPresenter
import com.example.rawgapp.common.di.InjectionModule
import com.google.firebase.auth.FirebaseAuth
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

object AuthModule : InjectionModule {

    override fun create() = module {
        single { FirebaseRepository(FirebaseAuth.getInstance()) }
        factoryOf(::RegistrationPresenter) bind RegistrationContract.Presenter::class
        factoryOf(::AuthInteractor)
    }
}