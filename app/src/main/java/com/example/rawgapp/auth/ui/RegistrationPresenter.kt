package com.example.rawgapp.auth.ui

import com.example.rawgapp.R
import com.example.rawgapp.auth.interactor.AuthInteractor
import com.example.rawgapp.auth.model.AuthState
import com.example.rawgapp.common.mvp.BasePresenter
import com.google.android.play.core.integrity.e
import com.google.android.play.integrity.internal.t
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class RegistrationPresenter(
    private val authInteractor: AuthInteractor
) : BasePresenter<RegistrationContract.View>(),
    RegistrationContract.Presenter {

    override fun auth() {
        try {
            launch {
                authInteractor.observeAuth()
                    .collectLatest { state -> handleAuthState(state) }
            }
        } catch (e: CancellationException) {
            Timber.e(e.message)
        } catch (t: Throwable) {
            Timber.e(t.message)
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
