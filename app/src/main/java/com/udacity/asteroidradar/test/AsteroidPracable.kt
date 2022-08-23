package com.udacity.asteroidradar.test

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class AsteroidPracable(
    val startDate: String,
    val endDate: String = "",
    val magnituide: String,
    val diamter: String,
    val velocity: String,
    val distance: String,
    val imageFlag: Boolean,
    @PrimaryKey()
    val name : String,

    var id :Int = Math.random().toInt()

) : Parcelable
