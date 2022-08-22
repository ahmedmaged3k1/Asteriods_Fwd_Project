package com.udacity.asteroidradar.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.StartDate
import com.udacity.asteroidradar.test.AsteroidPracable

@Dao
interface Dao {


    @Query("SELECT * FROM AsteroidPracable WHERE startDate >= :startDate AND startDate <= :endDate ORDER BY startDate ASC")
    fun getAsteroidsBySpecificDateOrder(startDate: String, endDate: String): List<AsteroidPracable>


    @Query("SELECT * FROM AsteroidPracable ORDER BY startDate ASC")
    fun getAllAsteroidsAscend(): List<AsteroidPracable>


    @Query("DELETE FROM AsteroidPracable WHERE startDate < :today")
    fun deleteAllPreviousDayAsteroids(today: String): Int


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPicture(pictureOfDay: PictureOfDay)

    @Query("SELECT * FROM PictureOfDay")
    suspend fun getPicture(): PictureOfDay


    @Query("DELETE FROM PictureOfDay")
    suspend fun deletePictureOfDay()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAsteroids(asteroids: List<AsteroidPracable>)

}