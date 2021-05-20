package com.danielvilha.trackmysleepquality.sleeptracker.adapter

import androidx.recyclerview.widget.DiffUtil
import com.danielvilha.trackmysleepquality.database.SleepNight

/**
 * Created by danielvilha on 20/05/21
 * https://github.com/danielvilha
 */
class SleepNightDiffCallback: DiffUtil.ItemCallback<SleepNight>() {
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }
}