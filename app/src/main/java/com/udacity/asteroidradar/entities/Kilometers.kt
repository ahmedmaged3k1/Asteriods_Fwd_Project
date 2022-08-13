package com.udacity.asteroidradar.entities

import com.google.gson.annotations.SerializedName


data class Kilometers (

    @SerializedName("estimated_diameter_min" ) var estimatedDiameterMin : Double? = null,
    @SerializedName("estimated_diameter_max" ) var estimatedDiameterMax : Double? = null

)