package com.udacity.asteroidradar.main

import AsteroidSample
import StartDate
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.entities.Asteroid
import com.udacity.asteroidradar.network.Credentials
import com.udacity.asteroidradar.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    //listOf(Asteroid(1,"asdas","sad",2.0,3.0,2.9,3.6,true))
    private  var asteroidsList = emptyList<StartDate>()


     suspend fun getNearAsteroids(endData: String,startData: String): List<StartDate> {
        withContext(Dispatchers.IO) {
            try {
                val response =
                    RetrofitInstance.getAsteroidsApi().getNearAsteroids( Credentials.apiKey,endData,startData)
                        .body()?.near_earth_objects?.startDate
                if (response!=null)
                {
                    asteroidsList= response 
                    Log.d(TAG, "getNearAsteroids size is : ${response.size}")
                }
           
                else{

                    Log.d(TAG, "getNearAsteroids: erorrrrrrr")

                }


            } catch (e: Exception) {
                Log.d(ContentValues.TAG, "getNearAsteroids :  erorr ${e.message}")
                e.printStackTrace()
            }
        }

        return asteroidsList
    }

}