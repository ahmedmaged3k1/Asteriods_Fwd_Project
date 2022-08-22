package com.udacity.asteroidradar.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroidradar.AsteroidSample
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.test.AsteroidPracable

@Database(
    entities = [AsteroidPracable::class, PictureOfDay::class],
    version = 0,
    exportSchema = false
)

abstract class LocalDatabase : RoomDatabase() {
    abstract val dao: Dao

    companion object {

        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        "local_asteroids_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}