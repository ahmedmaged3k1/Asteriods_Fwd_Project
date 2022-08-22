package com.udacity.asteroidradar.main


import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.AsteroidSample
import com.udacity.asteroidradar.StartDate
import com.udacity.asteroidradar.network.Credentials
import com.udacity.asteroidradar.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    //listOf(Asteroid(1,"asdas","sad",2.0,3.0,2.9,3.6,true))
    private var asteroidsList = emptyList<StartDate>()
    private lateinit var asteroids: AsteroidSample
    val asteroidsLive = MutableLiveData<List<StartDate>>()



    private suspend fun getNearAsteroids(endData: String, startData: String): List<StartDate>? {
        withContext(Dispatchers.IO) {
            try {
                val response =
                    RetrofitInstance.getAsteroidsApi()
                        .getNearAsteroids(Credentials.apiKey, endData, startData)
                        .body()?.near_earth_objects?.startDate
                val response2 =
                    RetrofitInstance.getAsteroidsApi()
                        .getNearAsteroids(Credentials.apiKey, endData, startData)
                        .body()
                if (response != null) {
                    asteroidsList = response

                    Log.d(
                        TAG,
                        "getNearAsteroids size is : ${response[2].close_approach_data.get(0).relative_velocity.kilometers_per_hour}"
                    )
                }
                if (response2 != null) {
                    asteroids = response2
                    Log.d(
                        TAG,
                        "getNearAsteroids: full si ${asteroids.near_earth_objects.startDate.size} "
                    )
                } else {

                    Log.d(TAG, "getNearAsteroids: erorrrrrrr")

                }


            } catch (e: Exception) {
                Log.d(ContentValues.TAG, "getNearAsteroids :  erorr ${e.message}")
                e.printStackTrace()
            }
        }

        return asteroidsList
    }
    fun getAsteroids(endData: String, startData: String){

        viewModelScope.launch {
            asteroidsLive.postValue(getNearAsteroids(endData, startData))
            Log.d(TAG, "getAsteroids view model : ${asteroidsList.size}")
        }
    }

}