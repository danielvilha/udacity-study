package com.danielvilha.trackmysleepquality.sleeptracker.adapter

import com.danielvilha.trackmysleepquality.database.SleepNight

/**
 * Created by danielvilha on 21/05/21
 * https://github.com/danielvilha
 */
sealed class DataItem {
    data class SleepNightItem(val sleepNight: SleepNight): DataItem() {
        override val id = sleepNight.nightId
    }
    object Header: DataItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}