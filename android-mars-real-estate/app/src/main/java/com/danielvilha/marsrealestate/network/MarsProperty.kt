package com.danielvilha.marsrealestate.network

import com.squareup.moshi.Json

/**
 * Created by danielvilha on 24/05/21
 * https://github.com/danielvilha
 */
data class MarsProperty(
    val id: String,
    // used to map img_src from JSON to imgSrcUrl in our class
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
)