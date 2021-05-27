package com.danielvilha.devbytes.ui.adapter

import com.danielvilha.devbytes.domain.Video

/**
 * Created by danielvilha on 26/05/21
 * https://github.com/danielvilha
 *
 * Click listener for Videos. By giving the block a name it helps a reader understand what it does.
 */
class VideoClick(val block: (Video) -> Unit) {
    /**
     * Called when a video is clicked
     *
     * @param video the video that was clicked
     */
    fun onClick(video: Video) = block(video)
}