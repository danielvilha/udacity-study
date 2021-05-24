package com.danielvilha.trackmysleepquality.sleeptracker.adapter

import androidx.recyclerview.widget.DiffUtil
import com.danielvilha.trackmysleepquality.database.SleepNight

/**
 * Created by danielvilha on 20/05/21
 * https://github.com/danielvilha
 */
class SleepNightDiffCallback: DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}