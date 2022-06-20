package com.mina.ui_list.di

import com.mina.ui_list.data.IMovieRepo
import com.mina.ui_list.data.MovieApi
import com.mina.ui_list.data.MovieRepo
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