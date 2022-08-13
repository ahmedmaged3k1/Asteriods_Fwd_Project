package com.udacity.asteroidradar.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EstimatedDiameter (

    @SerializedName("kilometers" ) var kilometers : Kilometers? = Kilometers(),
    @SerializedName("meters"     ) var meters     : Meters?     = Meters(),
    @SerializedName("miles"      ) var miles      : Miles?      = Miles(),
    @SerializedName("feet"       ) var feet       : Feet?       = Feet()

) : Parcelable