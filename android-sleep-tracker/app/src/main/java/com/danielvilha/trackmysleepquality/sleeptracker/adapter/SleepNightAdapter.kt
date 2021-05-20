package com.danielvilha.trackmysleepquality.sleeptracker.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danielvilha.trackmysleepquality.database.SleepNight

/**
 * Created by danielvilha on 16/04/21
 * https://github.com/danielvilha
 *
 * An adapter that provides a list of [SleepNight] to a RecyclerView.
 *
 * Setting SleepNight will cause the displayed list to update.
 */
class SleepNightAdapter: ListAdapter<SleepNight, SleepNightViewHolder>(
    SleepNightDiffCallback()
) {

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs a new [SleepNightViewHolder].
     *
     * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
     * to the RecyclerView such as were on the screen it was drawn during scrolling.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepNightViewHolder {
        return SleepNightViewHolder.from(parent)
    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs to show an item.
     *
     * The ViewHolder passed may be recycled, so make sure that this sets any properties that
     * may have been set previously.
     */
    override fun onBindViewHolder(holder: SleepNightViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}