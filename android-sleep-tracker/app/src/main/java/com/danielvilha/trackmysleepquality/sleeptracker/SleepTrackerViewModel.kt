package com.danielvilha.trackmysleepquality.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.danielvilha.trackmysleepquality.database.SleepDatabaseDao

/**
 * Created by danielvilha on 15/04/21
 * https://github.com/danielvilha
 */
class SleepTrackerViewModel(
    val database: SleepDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
}