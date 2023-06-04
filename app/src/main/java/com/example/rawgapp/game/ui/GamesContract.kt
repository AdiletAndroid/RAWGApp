package com.example.rawgapp.game.ui

import com.example.rawgapp.common.mvp.MvpPresenter
import com.example.rawgapp.common.mvp.MvpView
import com.example.rawgapp.game.model.GameModel

interface GamesContract {

    interface View : MvpView {
        fun showGames(games: List<GameModel>)
        fun showLoading(isLoading: Boolean)

    }

    interface Presenter : MvpPresenter<View> {
        fun getGames(page: Int)
    }
}