package com.udacity.asteroidradar.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RelativeVelocity (

    @SerializedName("kilometers_per_second" ) var kilometersPerSecond : String? = null,
    @SerializedName("kilometers_per_hour"   ) var kilometersPerHour   : String? = null,
    @SerializedName("miles_per_hour"        ) var milesPerHour        : String? = null

) : Parcelable