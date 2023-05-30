package com.example.rawgapp.main.ui

import com.example.rawgapp.common.mvp.BasePresenter
import com.example.rawgapp.main.interactor.MainInteractor

class MainPagePresenter(
    private val interactor: MainInteractor
) : BasePresenter<MainPageContract.View>(),
    MainPageContract.Presenter{
    override fun getGames(page: Int) {
        TODO("Not yet implemented")
    }

    override fun collectGamesFlow() {
        TODO("Not yet implemented")
    }

}