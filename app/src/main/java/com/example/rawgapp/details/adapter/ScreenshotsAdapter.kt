package com.example.rawgapp.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rawgapp.databinding.ItemScreenshotsBinding

class ScreenshotsAdapter(
    private val data: List<String>
) : RecyclerView.Adapter<ScreenshotsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScreenshotsAdapter.ViewHolder {
        val binding =
            ItemScreenshotsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val screenshot = data[position]
        holder.onBind(screenshot)
    }

    inner class ViewHolder(private val binding: ItemScreenshotsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(screenshot: String) {
            Glide
                .with(binding.imageViewScreenshot.context)
                .load(screenshot.trim())
                .into(binding.imageViewScreenshot)
        }
    }
}
