package com.example.rawgapp.root.ui

import com.example.rawgapp.common.mvp.MvpPresenter
import com.example.rawgapp.common.mvp.MvpView

interface RootContract {
    interface View : MvpView {
        fun showRegistration()
        fun showMainPage()
        fun setStatusBarColor()
    }

    interface Presenter : MvpPresenter<View> {
        fun checkAuthorization()
    }
}