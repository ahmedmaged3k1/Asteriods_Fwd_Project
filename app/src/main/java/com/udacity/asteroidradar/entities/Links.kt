package com.udacity.asteroidradar.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links (
    @SerializedName("next" ) var next : String? = null,
    @SerializedName("prev" ) var prev : String? = null,
    @SerializedName("self" ) var self : String? = null) : Parcelable