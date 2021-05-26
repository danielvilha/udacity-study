package com.danielvilha.marsrealestate.network

import com.squareup.moshi.Json

/**
 * Created by danielvilha on 24/05/21
 * https://github.com/danielvilha
 */
data class MarsProperty(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
)