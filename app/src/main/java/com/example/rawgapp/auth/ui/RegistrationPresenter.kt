package com.example.rawgapp.auth.ui

import com.example.rawgapp.R
import com.example.rawgapp.auth.interactor.AuthInteractor
import com.example.rawgapp.auth.model.AuthState
import com.example.rawgapp.common.mvp.BasePresenter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RegistrationPresenter(
    private val authInteractor: AuthInteractor
) : BasePresenter<RegistrationContract.View>(),
    RegistrationContract.Presenter {

    override fun attach(view: RegistrationContract.View) {
        super.attach(view)
        launch {
            authInteractor.observeAuth()
                .collectLatest { state -> handleAuthState(state) }
        }
    }

    override fun signUp(email: String, password: String) {
        authInteractor.signUp(email, password)
    }

    private fun handleAuthState(state: AuthState) {
        when (state) {
            is AuthState.Success -> {
                authInteractor.saveCredentials(state.credentials)
                view?.showMain()
            }

            is AuthState.Error -> view?.showError(R.string.auth_error)
        }
    }
}
