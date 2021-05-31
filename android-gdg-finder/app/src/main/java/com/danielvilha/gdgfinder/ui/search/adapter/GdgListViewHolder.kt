package com.danielvilha.gdgfinder.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danielvilha.gdgfinder.databinding.ListItemBinding
import com.danielvilha.gdgfinder.network.GdgChapter

/**
 * Created by danielvilha on 31/05/21
 * https://github.com/danielvilha
 */
class GdgListViewHolder(private var binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bind(listener: GdgClickListener, gdgChapter: GdgChapter) {
        binding.chapter = gdgChapter
        binding.clickListener = listener
        // This is important, because it forces the data binding to execute immediately,
        // which allows the RecyclerView to make the correct view size measurements
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): GdgListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemBinding.inflate(layoutInflater, parent, false)
            return GdgListViewHolder(binding)
        }
    }
}