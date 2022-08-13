package com.udacity.asteroidradar.entities

import com.google.gson.annotations.SerializedName

data class Links (
    @SerializedName("next" ) var next : String? = null,
    @SerializedName("prev" ) var prev : String? = null,
    @SerializedName("self" ) var self : String? = null)