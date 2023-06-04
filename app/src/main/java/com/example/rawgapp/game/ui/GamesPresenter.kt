package com.example.rawgapp.game.ui

import com.example.rawgapp.common.mvp.BasePresenter
import com.example.rawgapp.game.interactor.GamesInteractor
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import timber.log.Timber

class GamesPresenter(
    private val interactor: GamesInteractor
) : BasePresenter<GamesContract.View>(),
    GamesContract.Presenter {

    override fun getGames(page: Int) {
        launch {
            try {
                view?.showLoading(isLoading = true)
                val games = interactor.getGames(page)
                    view?.showGames(games)
            } catch (e: CancellationException) {
                Timber.e(e.message)
            } catch (t: Throwable) {
                Timber.e(t.message)
            } finally {
                view?.showLoading(isLoading = false)
            }
        }
    }
}