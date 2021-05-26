package com.danielvilha.marsrealestate.network

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by danielvilha on 24/05/21
 * https://github.com/danielvilha
 */
interface MarsApiService {

    @GET("realestate")
    fun getProperties(): Call<List<MarsProperty>>
}