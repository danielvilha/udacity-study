package com.danielvilha.marsrealestate.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielvilha.marsrealestate.network.MarsApi
import com.danielvilha.marsrealestate.network.MarsProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Created by danielvilha on 24/05/21
 * https://github.com/danielvilha
 *
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val status: LiveData<String>
        get() = _status

    private var _property = MutableLiveData<MarsProperty>()
    val property: LiveData<MarsProperty>
        get() = _property

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {
        coroutineScope.launch {
            val getPropertiesDeferred = MarsApi.retrofitService.getProperties()

            try {
                val listResult = getPropertiesDeferred.await()
                if (listResult.isNotEmpty())
                    _property.value = listResult[0]

                _status.value = "Success: ${listResult.size} Mars properties retrieved"
            } catch (t: Throwable) {
                _status.value = "Failure: ${t.message}"
            }
        }

        _status.value = "Set the Mars API Response here!"
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}