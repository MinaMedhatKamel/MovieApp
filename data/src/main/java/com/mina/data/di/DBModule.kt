package com.mina.data.di

import android.content.Context
import androidx.room.Room
import com.mina.common.BuildConfig
import com.mina.common.BuildConfig.DATA_BASE_NAME

import com.mina.data.database.MovieDao
import com.mina.data.database.MovieDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {
    @Provides
    @Singleton
    internal fun provideMovieDb(@ApplicationContext context: Context): MovieDb {
        return Room.databaseBuilder(context, MovieDb::class.java, BuildConfig.DATA_BASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideMovieDao(movieDb: MovieDb): MovieDao {
        return movieDb.movieDao()
    }
}