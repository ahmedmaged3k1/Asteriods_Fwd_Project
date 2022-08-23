package com.udacity.asteroidradar.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.test.AsteroidPracable

@Dao
interface Dao {


    @Query("SELECT * FROM AsteroidPracable WHERE startDate >= :startDate AND endDate <= :endDate ORDER BY startDate ASC")
    fun getAsteroidsBySpecificDateOrder(startDate: String, endDate: String): List<AsteroidPracable>


    @Query("SELECT * FROM AsteroidPracable ORDER BY startDate ASC")
    fun getAllAsteroidsAscend(): List<AsteroidPracable>

    @Query("SELECT * FROM AsteroidPracable ")
    fun getAllAsteroids(): List<AsteroidPracable>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAsteroids(asteroids: AsteroidPracable)

}