package com.udacity.asteroidradar.di

import android.app.Application
import com.udacity.asteroidradar.local.Dao
import com.udacity.asteroidradar.local.LocalDatabase
import com.udacity.asteroidradar.repository.LocalRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDb(context: Application): LocalDatabase {
        return LocalDatabase.getInstance(context)
    }
    @Provides
    @Singleton
    fun provideLocalRepo(doa  :Dao): LocalRepo {
        return LocalRepo(doa)
    }

    @Provides
    @Singleton
    fun provideRoomDao(coffeeDatabase: LocalDatabase): Dao {
        return coffeeDatabase.dao

    }
}


