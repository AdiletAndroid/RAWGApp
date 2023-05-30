package com.example.rawgapp.common.ui.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.rawgapp.main.model.GameModel

class MyDiffUtil(
    private val oldList: MutableList<GameModel>,
    private val newList: List<GameModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}