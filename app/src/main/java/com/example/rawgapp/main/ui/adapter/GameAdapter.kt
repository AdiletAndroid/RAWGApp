package com.example.rawgapp.main.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rawgapp.common.ui.diffUtil.MyDiffUtil
import com.example.rawgapp.databinding.ItemGameBinding
import com.example.rawgapp.main.model.GameModel

class GameAdapter(
    private val context: Context,
    private val onItemClick: (gameModel: GameModel) -> Unit,
    private val loadNextPage: () -> Unit
) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var data = mutableListOf<GameModel>()
    fun updateList(gameModel: List<GameModel>) {
        val diffCallback = MyDiffUtil(data, gameModel)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data = gameModel as MutableList<GameModel>
        diffResult.dispatchUpdatesTo(this)
    }

    private var isLoading = false
    fun setLoading(loading: Boolean) {
        isLoading = loading
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!isLoading && position == itemCount - 1) {
            loadNextPage.invoke()
        }
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return if (isLoading) {
            data.size + 1
        } else {
            data.size
        }
    }

    inner class ViewHolder(
        private val binding: ItemGameBinding,
        private val onItemClick: (gameModel: GameModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(gameModel: GameModel) {
            with(binding) {
                Glide.with(context)
                    .load(gameModel.backgroundImage)
                    .into(imageViewGame)
                textViewGameName.text = gameModel.name
                textViewSuggestions.text = gameModel.suggestionsCount.toString()
            }
            itemView.setOnClickListener {
                onItemClick.invoke(gameModel)
            }
        }
    }
}
