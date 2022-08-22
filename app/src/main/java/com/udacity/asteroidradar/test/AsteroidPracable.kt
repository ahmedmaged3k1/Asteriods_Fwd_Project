package com.udacity.asteroidradar.test

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AsteroidPracable(val date : String ,
                            val magnituide : String ,
                            val diamter : String ,
                            val velocity  : String ,
                            val distance  : String ,
                            val imageFlag :Boolean,
) : Parcelable
