package com.udacity.asteroidradar.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NearEarthObjects(
    @SerializedName("2015-09-08" ) var endDate: ArrayList<Asteroid>,
    @SerializedName("2015-09-07" ) var startDate: ArrayList<Asteroid>
) : Parcelable
