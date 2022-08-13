package com.udacity.asteroidradar.entities

import com.google.gson.annotations.SerializedName


data class NearEarthObjects(
    @SerializedName("2015-09-08" ) var endDate: ArrayList<Asteroid>,
    @SerializedName("2015-09-07" ) var startDate: ArrayList<Asteroid>
)
