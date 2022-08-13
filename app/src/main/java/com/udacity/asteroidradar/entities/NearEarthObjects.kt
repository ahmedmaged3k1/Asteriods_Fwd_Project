package com.udacity.asteroidradar.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NearEarthObjects(
    @SerializedName("end_date" ) var endDate: ArrayList<Asteroid>,
    @SerializedName("start_date" ) var startDate: ArrayList<Asteroid>
) : Parcelable
