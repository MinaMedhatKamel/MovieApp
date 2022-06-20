package com.mina.ui_list.data


import com.mina.common.BuildConfig
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepo constructor(
    private val movieApi: MovieApi
) : IMovieRepo {

    override suspend fun getTrendingMovies(): Response<MoviesResponse> {
        return movieApi.getTrendingMovies(BuildConfig.API_KEY)
    }
}