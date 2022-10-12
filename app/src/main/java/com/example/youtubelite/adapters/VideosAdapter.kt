package com.example.youtubelite.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubelite.databinding.VideoRowBinding
import com.example.youtubelite.models.SearchResponse

class VideosAdapter(
    private val onClickListener: OnClickListener) : ListAdapter<SearchResponse.Item,
        VideosAdapter.MenuViewHolder>(MenuDiffUtil) {
    inner class MenuViewHolder(private val binding: VideoRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: SearchResponse.Item?) {
            binding.textViewId.text = "YOUTUBE_VIDEO_ID: ${item?.id?.videoId}"
        }
    }

    object MenuDiffUtil : DiffUtil.ItemCallback<SearchResponse.Item>() {
        override fun areItemsTheSame(oldItem: SearchResponse.Item, newItem: SearchResponse.Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SearchResponse.Item, newItem: SearchResponse.Item): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            VideoRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
    }

    class OnClickListener(val clickListener: (item: SearchResponse.Item) -> Unit) {
        fun onClick(item: SearchResponse.Item) = clickListener(item)
    }
}