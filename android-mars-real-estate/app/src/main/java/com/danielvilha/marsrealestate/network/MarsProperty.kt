package com.danielvilha.marsrealestate.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by danielvilha on 24/05/21
 * https://github.com/danielvilha
 *
 * Gets Mars real estate property information from the Mars API Retrofit service and updates the
 * [MarsProperty] and [MarsApiStatus] [LiveData]. The Retrofit service returns a coroutine
 * Deferred, which we await to get the result of the transaction.
 * @param filter the [MarsApiFilter] that is sent as part of the web server request
 */
@Parcelize
data class MarsProperty(
    val id: String,
    // used to map img_src from JSON to imgSrcUrl in our class
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
): Parcelable {
    val isRental
        get() = type == "rent"
}