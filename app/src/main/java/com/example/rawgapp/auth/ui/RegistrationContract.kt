package com.example.rawgapp.auth.ui

import androidx.annotation.StringRes
import com.example.rawgapp.common.mvp.MvpPresenter
import com.example.rawgapp.common.mvp.MvpView

interface RegistrationContract {

    interface View : MvpView {
        fun showMain()
        fun showError(@StringRes errorResId: Int)
    }

    interface Presenter : MvpPresenter<View> {
        fun signUp(email: String, password: String)
    }
}