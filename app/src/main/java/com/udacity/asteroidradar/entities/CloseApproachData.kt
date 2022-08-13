package com.udacity.asteroidradar.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CloseApproachData (

    @SerializedName("close_approach_date"       ) var closeApproachDate      : String?           = null,
    @SerializedName("close_approach_date_full"  ) var closeApproachDateFull  : String?           = null,
    @SerializedName("epoch_date_close_approach" ) var epochDateCloseApproach : Int?              = null,
    @SerializedName("relative_velocity"         ) var relativeVelocity       : RelativeVelocity? = RelativeVelocity(),
    @SerializedName("miss_distance"             ) var missDistance           : MissDistance?     = MissDistance(),
    @SerializedName("orbiting_body"             ) var orbitingBody           : String?           = null

) : Parcelable