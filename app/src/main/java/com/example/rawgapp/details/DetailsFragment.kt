package com.example.rawgapp.details

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.rawgapp.R
import com.example.rawgapp.common.mvp.BaseFragment
import com.example.rawgapp.databinding.FragmentDetailsBinding
import com.example.rawgapp.details.adapter.ScreenshotsAdapter
import com.example.rawgapp.game.model.GameModel
import com.example.rawgapp.utils.extensions.popBackStack
import com.example.rawgapp.utils.extensions.viewbinding.viewBinding

private const val ARG_GAME = "GAME_KEY"

class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    companion object {
        fun create(gameModel: GameModel): DetailsFragment {
            val bundle = Bundle()
            bundle.putParcelable(ARG_GAME, gameModel)
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private val binding: FragmentDetailsBinding by viewBinding()
    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private val game: GameModel by lazy { requireArguments().getParcelable<GameModel>(ARG_GAME) as GameModel }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        game.let { showGame(it) }
        with(binding) {
            toolbar.setNavigationOnClickListener {
                popBackStack()
            }
        }
    }

    private fun showGame(gameModel: GameModel) {
        with(binding) {
            textViewName.text = gameModel.name
            textViewRating.text = gameModel.rating.toString()
            textViewRatingTop.text = gameModel.ratingTop.toString()
            ratingBar.rating = gameModel.ratingTop
            textViewDate.text = gameModel.released
            Glide.with(requireContext())
                .load(gameModel.backgroundImage)
                .into(imageView)
            recyclerViewScreensots.layoutManager = layoutManager
            recyclerViewScreensots.adapter = game.let { ScreenshotsAdapter(it.shortScreenshots) }
        }
    }
}
