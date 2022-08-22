package com.udacity.asteroidradar.main


import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.AsteroidSample
import com.udacity.asteroidradar.local.Dao
import com.udacity.asteroidradar.network.Credentials
import com.udacity.asteroidradar.network.RetrofitInstance
import com.udacity.asteroidradar.test.AsteroidPracable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val doa: Dao) : ViewModel() {

    private lateinit var asteroids: AsteroidSample
    val asteroidsLive = MutableLiveData<List<AsteroidPracable>>()
    var image: String = ""


    private fun insertIntoRoom(endData: String, startData: String) {
        viewModelScope.launch {
            val asteroidList = mutableListOf<AsteroidPracable>()
            val response =
                RetrofitInstance.getAsteroidsApi()
                    .getNearAsteroids(Credentials.apiKey, endData, startData)
                    .body()?.near_earth_objects
            if (response != null) {
                response.startDate.forEachIndexed { index, startDate ->
                    val asteroid = AsteroidPracable(
                        startDate = startData,
                        endDate = endData,
                        startDate.absolute_magnitude_h.toString(),
                        startDate.close_approach_data[0].relative_velocity.kilometers_per_hour.toString(),
                        startDate.estimated_diameter.kilometers.estimated_diameter_max.toString(),
                        startDate.close_approach_data[0].miss_distance.kilometers.toString(),
                        startDate.is_potentially_hazardous_asteroid,
                        startDate.name
                    )
                    Log.d(TAG, "insertIntoRoom: ${asteroid.toString()}\n")
                    doa.insertAllAsteroids(asteroid)


                }
            }

        }
    }

    fun getAsteroids(endData: String, startData: String) {

        viewModelScope.launch {
            insertIntoRoom(endData, startData)
            Log.d(TAG, "getAsteroids: ${doa.getAllAsteroidsAscend().toString()}")
            asteroidsLive.postValue(doa.getAllAsteroidsAscend())

        }
    }

    suspend fun getImage() {
        viewModelScope.launch {

            val response =
                RetrofitInstance.getAsteroidsApi().getDayImage(Credentials.apiKey).body()
            if (!response?.mediaType.equals("video")) {
                image = response?.url.toString()
                Log.d(TAG, "getImage:  imageeee $image ")
            }


        }
    }
}

