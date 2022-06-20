package com.mina.moviedetails.di

import com.mina.moviedetails.data.IMovieDetailsRepo
import com.mina.moviedetails.data.MovieDetailsApi
import com.mina.moviedetails.data.MovieDetailsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieDetailsModule {

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieDetailsApi =
        retrofit.create(MovieDetailsApi::class.java)

    @Singleton
    @Provides
    fun provideMovieRepository(
        moviesDetailsApi: MovieDetailsApi
    ): IMovieDetailsRepo {
        return MovieDetailsRepo(moviesDetailsApi)
    }

}