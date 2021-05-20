package com.danielvilha.trackmysleepquality.sleeptracker.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.danielvilha.trackmysleepquality.R
import com.danielvilha.trackmysleepquality.convertDurationToFormatted
import com.danielvilha.trackmysleepquality.convertNumericQualityToString
import com.danielvilha.trackmysleepquality.database.SleepNight

/**
 * Created by danielvilha on 20/05/21
 * https://github.com/danielvilha
 */
@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNight?) {
    item?.let {
        text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, context.resources)
    }
}

@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(item: SleepNight?) {
    item?.let {
        text = convertNumericQualityToString(item.sleepQuality, context.resources)
    }
}

@BindingAdapter("sleepImage")
fun ImageView.setImageSleep(item: SleepNight?) {
    item?.let {
        setImageResource(when(it.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_sleep_active
        })
    }
}