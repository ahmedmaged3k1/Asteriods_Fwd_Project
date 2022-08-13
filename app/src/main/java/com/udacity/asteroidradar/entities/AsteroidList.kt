package com.udacity.asteroidradar.entities

import com.google.gson.annotations.SerializedName

data class AsteroidList(
    @SerializedName("links"              ) var links            : Links? ,
    @SerializedName("element_count"      ) var elementCount     : Int?              = null,
    @SerializedName("near_earth_objects" ) var nearEarthObjects: NearEarthObjects )
