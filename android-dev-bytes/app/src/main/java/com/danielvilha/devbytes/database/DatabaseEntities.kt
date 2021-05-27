package com.danielvilha.devbytes.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danielvilha.devbytes.domain.Video

/**
 * Created by danielvilha on 26/05/21
 * https://github.com/danielvilha
 *
 * This is a database objects class
 */

@Entity
data class DatabaseVideo(
    @PrimaryKey
    val url: String,
    val updated: String,
    val title: String,
    val description: String,
    val thumbnail: String
)

fun List<DatabaseVideo>.asDomainModel(): List<Video> {
    return map {
        Video(
            url = it.url,
            title = it.title,
            description = it.description,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }
}