package com.udacity.asteroidradar

import CloseApproachData
import Estimated_diameter
import Links
import Miss_distance
import Relative_velocity
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/*
Copyright (c) 2022 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */

@Parcelize
data class EndDate (

    @SerializedName("links") val links : Links,
    @SerializedName("id") val id : Int,
    @SerializedName("neo_reference_id") val neo_reference_id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("relative_velocity") val relative_velocity : Relative_velocity,
    @SerializedName("miss_distance") val miss_distance : Miss_distance,
    @SerializedName("nasa_jpl_url") val nasa_jpl_url : String,
    @SerializedName("absolute_magnitude_h") val absolute_magnitude_h : Double,
    @SerializedName("estimated_diameter") val estimated_diameter : Estimated_diameter,
    @SerializedName("is_potentially_hazardous_asteroid") val is_potentially_hazardous_asteroid : Boolean,
    @SerializedName("close_approach_data") val close_approach_data : List<CloseApproachData>,
    @SerializedName("is_sentry_object") val is_sentry_object : Boolean
) : Parcelable