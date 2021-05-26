package com.danielvilha.marsrealestate.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Created by danielvilha on 24/05/21
 * https://github.com/danielvilha
 */
interface MarsApiService {

    @GET("realestate")
    fun getProperties(): Deferred<List<MarsProperty>>
}