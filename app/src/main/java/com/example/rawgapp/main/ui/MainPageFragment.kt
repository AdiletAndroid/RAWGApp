package com.example.rawgapp.main.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rawgapp.R
import com.example.rawgapp.common.mvp.BaseMvpFragment
import com.example.rawgapp.common.ui.endlessScroll.EndlessScrollListener
import com.example.rawgapp.databinding.FragmentMainPageBinding
import com.example.rawgapp.details.DetailsFragment
import com.example.rawgapp.main.model.GameModel
import com.example.rawgapp.main.ui.adapter.GameAdapter
import com.example.rawgapp.utils.extensions.replaceFragment
import com.example.rawgapp.utils.extensions.viewbinding.viewBinding
import org.koin.android.ext.android.inject

class MainPageFragment :
    BaseMvpFragment<MainPageContract.View, MainPageContract.Presenter>(R.layout.fragment_main_page),
    MainPageContract.View {

    companion object {
        fun create(): MainPageFragment = MainPageFragment()
    }

    private val binding: FragmentMainPageBinding by viewBinding()
    private var page = 1
    override val presenter: MainPagePresenter by inject()

    private val adapter: GameAdapter by lazy {
        GameAdapter(requireContext(), { game ->
            openDetailsPage(game)
        }, {
            presenter.getGamesFlow(page)
        })
    }

    private val layoutManager: GridLayoutManager by lazy {
        GridLayoutManager(requireContext(), 2)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
            val scrollListener = EndlessScrollListener(layoutManager, { page ->
                presenter.getGamesFlow(page)
            }, hasMore = true)
            recyclerView.addOnScrollListener(scrollListener)
            presenter.getGamesFlow(1)
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
        adapter.setLoading(isLoading)
    }

    private fun openDetailsPage(gameModel: GameModel) {
        val fragment = DetailsFragment.create(gameModel)
        replaceFragment(fragment)
    }
}