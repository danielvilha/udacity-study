package com.danielvilha.marsrealestate.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by danielvilha on 24/05/21
 * https://github.com/danielvilha
 *
 * A public interface that exposes the [getProperties] method
 */
interface MarsApiService {

    /**
     * Returns a Coroutine [List] of [MarsProperty] which can be fetched with await() if in a Coroutine scope.
     * The @GET annotation indicates that the "realestate" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("realestate")
    fun getProperties(@Query("filter") type: String): Deferred<List<MarsProperty>>
}