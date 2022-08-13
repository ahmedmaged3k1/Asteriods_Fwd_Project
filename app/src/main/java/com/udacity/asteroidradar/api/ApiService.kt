package com.udacity.asteroidradar.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("neo/rest/v1/feed")
    suspend fun getNearAsteroids(@Query("api_key")key: String,@Query("end_date")endDate: String,
                                 @Query("start_date")startDate: String)
}