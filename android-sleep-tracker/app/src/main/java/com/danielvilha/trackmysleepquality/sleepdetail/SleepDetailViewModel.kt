package com.danielvilha.trackmysleepquality.sleepdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielvilha.trackmysleepquality.database.SleepDatabaseDao
import com.danielvilha.trackmysleepquality.database.SleepNight

/**
 * Created by danielvilha on 21/05/21
 * https://github.com/danielvilha
 *
 * ViewModel for SleepDetailViewModel.
 *
 * @param sleepNightKey The key of the current night we are working on.
 * @param dataSource This is the database dao file.
 */
class SleepDetailViewModel(
    private val sleepNightKey: Long = 0L,
    dataSource: SleepDatabaseDao
): ViewModel() {

    /**
     * Hold a reference to SleepDatabase via its SleepDatabaseDao.
     */
    val database = dataSource

    private val night = MediatorLiveData<SleepNight>()

    fun getNight() = night

    init {
        night.addSource(database.getNightWithId(sleepNightKey), night::setValue)
    }

    /**
     * Variable that tells the fragment whether it should navigate to [SleepDetailFragment].
     *
     * This is `private` because we don't want to expose the ability to set [MutableLiveData] to
     * the [SleepDetailFragment]
     */
    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()

    /**
     * When true immediately navigate back to the [SleepDetailFragment]
     */
    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker

    /**
     * Call this immediately after navigating to [SleepDetailFragment]
     */
    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }

    fun onClose() {
        _navigateToSleepTracker.value = true
    }
}