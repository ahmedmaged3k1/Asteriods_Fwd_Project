package com.udacity.asteroidradar.api

import com.udacity.asteroidradar.AsteroidSample
import com.udacity.asteroidradar.ImageOfDay
import com.udacity.asteroidradar.entities.AsteroidList
import com.udacity.asteroidradar.json.test
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("neo/rest/v1/feed")
    suspend fun getNearAsteroids(@Query("api_key")key: String,@Query("end_date")endDate: String,
                                 @Query("start_date")startDate: String): Response<test>
    @GET("planetary/apod")
    suspend fun getDayImage(@Query("api_key")key: String): Response<ImageOfDay>
}