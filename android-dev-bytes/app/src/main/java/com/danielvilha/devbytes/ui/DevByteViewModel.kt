package com.danielvilha.devbytes.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.danielvilha.devbytes.domain.Video
import com.danielvilha.devbytes.network.Network.devbytes
import com.danielvilha.devbytes.network.asDomainModel
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Created by danielvilha on 26/05/21
 * https://github.com/danielvilha
 *
 * DevByteViewModel designed to store and manage UI-related data in a lifecycle conscious way. This
 * allows data to survive configuration changes such as screen rotations. In addition, background
 * work such as fetching network results can continue through configuration changes and deliver
 * results after the new Fragment or Activity is available.
 *
 * @param application The application that this viewmodel is attached to, it's safe to hold a
 * reference to applications across rotation since Application is never recreated during actiivty
 * or fragment lifecycle events.
 */
class DevByteViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * A playlist of videos that can be shown on the screen. This is private to avoid exposing a
     * way to set this value to observers.
     */
    private val _playlist = MutableLiveData<List<Video>>()

    /**
     * A playlist of videos that can be shown on the screen. Views should use this to get access
     * to the data.
     */
    val playlist: LiveData<List<Video>>
        get() = _playlist

    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        refreshDataFromNetwork()
    }

    /**
     * Refresh data from network and pass it via LiveData. Use a coroutine launch to get to
     * background thread.
     */
    private fun refreshDataFromNetwork() = viewModelScope.launch {
        try {
            val playlist = devbytes.getPlaylist().await()
            _playlist.postValue(playlist.asDomainModel())
        } catch (networkError: IOException) {
            // Show an infinite loading spinner if the request fails
            // challenge exercise: show an error to the user if the network request fails
        }
    }
}