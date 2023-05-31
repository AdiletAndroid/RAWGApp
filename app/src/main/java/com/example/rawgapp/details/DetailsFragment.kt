package com.example.rawgapp.details

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.rawgapp.R
import com.example.rawgapp.common.mvp.BaseFragment
import com.example.rawgapp.databinding.FragmentDetailsBinding
import com.example.rawgapp.main.model.GameModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val game = arguments?.getParcelable(ARG_GAME) as GameModel?
        game?.let { showGame(it) }
        binding.toolbar.setNavigationOnClickListener {
            popBackStack()
        }
    }

    private fun showGame(gameModel: GameModel) {
        with(binding) {
            textViewName.text = gameModel.name
            textViewRating.text = gameModel.rating.toString()
            textViewReview.text = gameModel.metacritic.toString()
            textViewDate.text = gameModel.added.toString()
            Glide.with(requireContext())
                .load(gameModel.backgroundImage)
                .into(imageView)
        }
    }
}