package com.example.rawgapp.main.ui

import com.example.rawgapp.common.mvp.BasePresenter
import com.example.rawgapp.main.interactor.MainInteractor
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPagePresenter(
    private val interactor: MainInteractor
) : BasePresenter<MainPageContract.View>(),
    MainPageContract.Presenter {

    override fun getGamesFlow(page: Int) {
        launch {
            try {
                view?.showLoading(isLoading = true)
                val gamesFlow = interactor.getGamesFlow(page)
                gamesFlow.collect { games ->
                    view?.showGames(games)
                }
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