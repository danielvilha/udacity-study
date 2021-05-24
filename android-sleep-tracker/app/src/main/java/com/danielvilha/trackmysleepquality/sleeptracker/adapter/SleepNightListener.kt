package com.danielvilha.trackmysleepquality.sleeptracker.adapter

import com.danielvilha.trackmysleepquality.database.SleepNight

/**
 * Created by danielvilha on 21/05/21
 * https://github.com/danielvilha
 */
class SleepNightListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(night: SleepNight) = clickListener(night.nightId)
}