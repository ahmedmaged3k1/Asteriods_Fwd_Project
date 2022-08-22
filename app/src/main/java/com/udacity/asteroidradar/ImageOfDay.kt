package com.udacity.asteroidradar

import com.google.gson.annotations.SerializedName

data class ImageOfDay( @SerializedName("date"            ) var date           : String? = null,
                       @SerializedName("explanation"     ) var explanation    : String? = null,
                       @SerializedName("media_type"      ) var mediaType      : String? = null,
                       @SerializedName("service_version" ) var serviceVersion : String? = null,
                       @SerializedName("title"           ) var title          : String? = null,
                       @SerializedName("url"             ) var url            : String? = null)
