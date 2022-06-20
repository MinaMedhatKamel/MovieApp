package com.mina.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mina.common.data.models.Movie
import javax.inject.Singleton

@Singleton
@Database(entities = [(Movie::class)], version = 1, exportSchema = false)
abstract class MovieDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}