package com.danielvilha.devbytes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.danielvilha.devbytes.database.VideosDatabase
import com.danielvilha.devbytes.database.asDomainModel
import com.danielvilha.devbytes.domain.Video
import com.danielvilha.devbytes.network.Network
import com.danielvilha.devbytes.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by danielvilha on 27/05/21
 * https://github.com/danielvilha
 *
 * Repository for fetching devbyte videos from the network and storing them on disk.
 *
 * Repository modules handle data operations. They provide a clean API so that the rest of the api
 * can retrieve this data easily. They know where to get the data from and what API call to make
 * when data is updated. You can consider repositories to be mediators between different data
 * source, in our case it mediates between a network API and an offline database cache.
 */
class VideosRepository(private val database: VideosDatabase) {

    /**
     * A playlist of videos that can be shown on the screen.
     */
    val videos: LiveData<List<Video>> = Transformations.map(database.videoDao.getVideos()) {
        it.asDomainModel()
    }

    /**
     * Refresh the videos stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     * To actually load the videos for use, observe [videos]
     */
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = Network.devbytes.getPlaylist().await()
            database.videoDao.insertAll(*playlist.asDatabaseModel())
        }
    }
}