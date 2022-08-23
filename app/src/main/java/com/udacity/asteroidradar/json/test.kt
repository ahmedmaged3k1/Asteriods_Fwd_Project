package com.udacity.asteroidradar.json

import com.google.gson.annotations.SerializedName

data class test(
    val element_count: Int,
    val links: Links,
    val near_earth_objects: NearEarthObjects
)

data class Links(
    val next: String,
    val prev: String,
    val self: String
)

data class NearEarthObjects(
    val `2018-05-04`: List<X20180504>,
    val `2018-05-05`: List<X20180505>
)

data class X20180504(
    val absolute_magnitude_h: Double,
    val close_approach_data: List<CloseApproachData>,
    val estimated_diameter: EstimatedDiameter,
    val id: String,
    val is_potentially_hazardous_asteroid: Boolean,
    val is_sentry_object: Boolean,
    val links: LinksX,
    val name: String,
    val nasa_jpl_url: String,
    val neo_reference_id: String
)

data class X20180505(
    val absolute_magnitude_h: Double,
    val close_approach_data: List<CloseApproachDataX>,
    val estimated_diameter: EstimatedDiameterX,
    val id: String,
    val is_potentially_hazardous_asteroid: Boolean,
    val is_sentry_object: Boolean,
    val links: LinksX,
    val name: String,
    val nasa_jpl_url: String,
    val neo_reference_id: String
)

data class CloseApproachData(
    val close_approach_date: String,
    val close_approach_date_full: String,
    val epoch_date_close_approach: Long,
    val miss_distance: MissDistance,
    val orbiting_body: String,
    val relative_velocity: RelativeVelocity
)

data class EstimatedDiameter(
    val feet: Feet,
    val kilometers: Kilometers,
    val meters: Meters,
    val miles: Miles
)

data class LinksX(
    val self: String
)

data class MissDistance(
    val astronomical: String,
    val kilometers: String,
    val lunar: String,
    val miles: String
)

data class RelativeVelocity(
    val kilometers_per_hour: String,
    val kilometers_per_second: String,
    val miles_per_hour: String
)

data class Feet(
    val estimated_diameter_max: Double,
    val estimated_diameter_min: Double
)

data class Kilometers(
    val estimated_diameter_max: Double,
    val estimated_diameter_min: Double
)

data class Meters(
    val estimated_diameter_max: Double,
    val estimated_diameter_min: Double
)

data class Miles(
    val estimated_diameter_max: Double,
    val estimated_diameter_min: Double
)

data class CloseApproachDataX(
    val close_approach_date: String,
    val close_approach_date_full: String,
    val epoch_date_close_approach: Long,
    val miss_distance: MissDistanceX,
    val orbiting_body: String,
    val relative_velocity: RelativeVelocityX
)

data class RelativeVelocityX(
    @SerializedName("kilometers_per_second") var kilometersPerSecond: String? = null,
    @SerializedName("kilometers_per_hour") var kilometersPerHour: String? = null,
    @SerializedName("miles_per_hour") var milesPerHour: String? = null
)

data class MissDistanceX(
    @SerializedName("astronomical") var astronomical: String? = null,
    @SerializedName("lunar") var lunar: String? = null,
    @SerializedName("kilometers") var kilometers: String? = null,
    @SerializedName("miles") var miles: String? = null
)

data class EstimatedDiameterX(
    val feet: FeetX,
    val kilometers: KilometersX,
    val meters: MetersX,
    val miles: MilesX
)

data class FeetX(

    @SerializedName("estimated_diameter_min") var estimatedDiameterMin: Double? = null,
    @SerializedName("estimated_diameter_max") var estimatedDiameterMax: Double? = null

)

data class MilesX(

    @SerializedName("estimated_diameter_min") var estimatedDiameterMin: Double? = null,
    @SerializedName("estimated_diameter_max") var estimatedDiameterMax: Double? = null

)

data class MetersX(

    @SerializedName("estimated_diameter_min") var estimatedDiameterMin: Double? = null,
    @SerializedName("estimated_diameter_max") var estimatedDiameterMax: Double? = null

)

data class KilometersX(

    @SerializedName("estimated_diameter_min") var estimatedDiameterMin: Double? = null,
    @SerializedName("estimated_diameter_max") var estimatedDiameterMax: Double? = null

)