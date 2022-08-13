package com.udacity.asteroidradar.main

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
    private  var asteroidsList =listOf(Asteroid(1,"asdas","sad",2.0,3.0,2.9,3.6,true))


     suspend fun getNearAsteroids(endData: String,startData: String): List<Asteroid> {
        withContext(Dispatchers.IO) {
            try {
                var response =
                    RetrofitInstance.getAsteroidsApi().getNearAsteroids( Credentials.apiKey,endData,startData)
                        .body()?.nearEarthObjects?.startDate ?:listOf(
                        Asteroid(1,"asdas","sad",2.0
                            ,3.0,2.9,3.6,true)
                    )
                asteroidsList= response

                Log.d(TAG, "getNearAsteroids id is : ${response.get(0).relativeVelocity}")



            } catch (e: Exception) {
                Log.d(ContentValues.TAG, "getNearAsteroids :  erorr ${e.message}")
                e.printStackTrace()
            }
        }

        return asteroidsList
    }

}