package com.danielvilha.dessertpusher

import android.app.Application
import timber.log.Timber

/**
 * Created by danielvilha on 13/04/21
 * https://github.com/danielvilha
 */
class PusherApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}