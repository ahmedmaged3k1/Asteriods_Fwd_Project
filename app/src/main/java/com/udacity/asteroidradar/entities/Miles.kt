package com.udacity.asteroidradar.entities


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Miles (

    @SerializedName("estimated_diameter_min" ) var estimatedDiameterMin : Double? = null,
    @SerializedName("estimated_diameter_max" ) var estimatedDiameterMax : Double? = null

) : Parcelable