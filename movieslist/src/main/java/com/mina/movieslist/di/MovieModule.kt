package com.mina.movieslist.di

import com.mina.movieslist.data.IMovieRepo
import com.mina.movieslist.data.MovieApi
import com.mina.movieslist.data.MovieRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieModule {

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    @Singleton
    @Provides
    fun provideMovieRepository(
        moviesApi: MovieApi
    ): IMovieRepo {
        return MovieRepo(moviesApi)
    }

}