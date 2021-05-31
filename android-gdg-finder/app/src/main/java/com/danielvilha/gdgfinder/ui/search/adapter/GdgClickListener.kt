package com.danielvilha.gdgfinder.ui.search.adapter

import com.danielvilha.gdgfinder.network.GdgChapter

/**
 * Created by danielvilha on 31/05/21
 * https://github.com/danielvilha
 */
class GdgClickListener(val clickListener: (chapter: GdgChapter) -> Unit) {
    fun onClick(chapter: GdgChapter) = clickListener(chapter)
}