package com.example.rawgapp.main.ui

import com.example.rawgapp.common.mvp.MvpPresenter
import com.example.rawgapp.common.mvp.MvpView
import com.example.rawgapp.main.model.GameModel

interface MainPageContract {

    interface View : MvpView {
        fun showGames(article: List<GameModel>)
        fun showLoading(isLoading: Boolean)

    }

    interface Presenter: MvpPresenter<View> {
        fun getGames(page: Int)
        fun collectGamesFlow()
    }
}