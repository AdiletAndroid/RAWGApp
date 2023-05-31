package com.example.rawgapp.root.ui

import com.example.rawgapp.auth.interactor.AuthInteractor
import com.example.rawgapp.common.mvp.BasePresenter

class RootPresenter(
    private val authInteractor: AuthInteractor
) : BasePresenter<RootContract.View>(), RootContract.Presenter {

    override fun checkAuthorization() {
        val isAuthorized = authInteractor.isAuthorized()
        if (isAuthorized) {
            view?.showMainPage()
        } else {
            view?.showRegistration()
        }
    }

}