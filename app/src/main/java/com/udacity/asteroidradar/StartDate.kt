package com.udacity.asteroidradar

import CloseApproachData
import Estimated_diameter
import Links
import Miss_distance
import Relative_velocity
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StartDate (

	@SerializedName("links") val links : Links,
	@SerializedName("id") val id : Int,
	@SerializedName("neo_reference_id") val neo_reference_id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("relative_velocity") val relative_velocity : Relative_velocity,
	@SerializedName("miss_distance") val miss_distance : Miss_distance,
	@SerializedName("estimated_diameter_max") val estimated_diameter_max : Double,
	@SerializedName("nasa_jpl_url") val nasa_jpl_url : String,
	@SerializedName("absolute_magnitude_h") val absolute_magnitude_h : Double,
	@SerializedName("kilometers_per_second") val kilometers_per_second : Double,
	@SerializedName("estimated_diameter") val estimated_diameter : Estimated_diameter,
	@SerializedName("is_potentially_hazardous_asteroid") val is_potentially_hazardous_asteroid : Boolean,
	@SerializedName("close_approach_data") val close_approach_data : List<CloseApproachData>,
	@SerializedName("kilometers") val kilometers : Double,
	@SerializedName("is_sentry_object") val is_sentry_object : Boolean
) : Parcelable