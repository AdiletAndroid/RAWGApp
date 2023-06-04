package com.example.rawgapp.game.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rawgapp.R
import com.example.rawgapp.common.mvp.BaseMvpFragment
import com.example.rawgapp.common.ui.endlessScroll.EndlessScrollListener
import com.example.rawgapp.databinding.FragmentGamesBinding
import com.example.rawgapp.details.DetailsFragment
import com.example.rawgapp.game.model.GameModel
import com.example.rawgapp.game.ui.adapter.GameAdapter
import com.example.rawgapp.utils.extensions.replaceFragment
import com.example.rawgapp.utils.extensions.viewbinding.viewBinding
import org.koin.android.ext.android.inject
import timber.log.Timber

class GamesFragment :
    BaseMvpFragment<GamesContract.View, GamesContract.Presenter>(R.layout.fragment_games),
    GamesContract.View {

    companion object {
        fun create(): GamesFragment = GamesFragment()
    }

    private val binding: FragmentGamesBinding by viewBinding()
    override val presenter: GamesPresenter by inject()

    private val adapter: GameAdapter by lazy {
        GameAdapter { game ->
            openDetailsPage(game)
        }
    }

    private val layoutManager: GridLayoutManager by lazy {
        GridLayoutManager(requireContext(), 2)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
            val scrollListener = EndlessScrollListener(layoutManager) { page ->
                Timber.d("$$$ page $page")
                presenter.getGames(page)
            }
            recyclerView.addOnScrollListener(scrollListener)
            presenter.getGames(1)
        }
    }

    override fun showGames(games: List<GameModel>) {
        adapter.updateList(games)
    }

    override fun showLoading(isLoading: Boolean) {
        with(binding) {
            progressBar.isVisible = isLoading
            recyclerView.isVisible = !isLoading
        }
    }

    private fun openDetailsPage(gameModel: GameModel) {
        val fragment = DetailsFragment.create(gameModel)
        replaceFragment(fragment)
    }
}