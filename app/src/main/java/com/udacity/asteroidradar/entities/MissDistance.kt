package com.udacity.asteroidradar.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MissDistance (

    @SerializedName("astronomical" ) var astronomical : String? = null,
    @SerializedName("lunar"        ) var lunar        : String? = null,
    @SerializedName("kilometers"   ) var kilometers   : String? = null,
    @SerializedName("miles"        ) var miles        : String? = null

) : Parcelable