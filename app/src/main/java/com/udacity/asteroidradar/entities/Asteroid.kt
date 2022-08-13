package com.udacity.asteroidradar.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Asteroid(  @SerializedName("links"                             ) var links                          : Links?                       = Links(),
                      @SerializedName("id"                                ) var id                             : String?                      = null,
                      @SerializedName("neo_reference_id"                  ) var neoReferenceId                 : String?                      = null,
                      @SerializedName("name"                              ) var name                           : String?                      = null,
                      @SerializedName("nasa_jpl_url"                      ) var nasaJplUrl                     : String?                      = null,
                      @SerializedName("absolute_magnitude_h"              ) var absoluteMagnitudeH             : Double?                      = null,
                      @SerializedName("estimated_diameter"                ) var estimatedDiameter              : EstimatedDiameter?           = EstimatedDiameter(),
                      @SerializedName("is_potentially_hazardous_asteroid" ) var isPotentiallyHazardousAsteroid : Boolean?                     = null,
                      @SerializedName("close_approach_data"               ) var closeApproachData              : ArrayList<CloseApproachData> = arrayListOf(),
                      @SerializedName("is_sentry_object"                  ) var isSentryObject                 : Boolean?                     = null):Parcelable
