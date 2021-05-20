package com.danielvilha.trackmysleepquality.sleeptracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danielvilha.trackmysleepquality.database.SleepNight
import com.danielvilha.trackmysleepquality.databinding.ListItemSleepNightBinding

/**
 * Created by danielvilha on 20/05/21
 * https://github.com/danielvilha
 */
class SleepNightViewHolder private constructor(private val binding: ListItemSleepNightBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SleepNight) {
        binding.sleep = item
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): SleepNightViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)

            return SleepNightViewHolder(binding)
        }
    }
}