package com.example.rawgapp.game.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rawgapp.databinding.ItemGameBinding
import com.example.rawgapp.game.model.GameModel

class GameAdapter(
    private val onItemClick: (gameModel: GameModel) -> Unit
) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private val data = mutableListOf<GameModel>()
    fun updateList(newGames: List<GameModel>) {
        val positionStart = data.size
        data += newGames
        notifyItemRangeInserted(positionStart, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(
        private val binding: ItemGameBinding,
        private val onItemClick: (gameModel: GameModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(gameModel: GameModel) {
            with(binding) {
                Glide.with(imageViewGame.context)
                    .load(gameModel.backgroundImage)
                    .into(imageViewGame)
                textViewGameName.text = gameModel.name
                textViewReleased.text = gameModel.released
            }
            itemView.setOnClickListener {
                onItemClick.invoke(gameModel)
            }
        }
    }
}
