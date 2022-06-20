package com.mina.moviedetails.data


import com.mina.common.BuildConfig
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class MovieDetailsRepo constructor(
    private val movieApi: MovieDetailsApi
) : IMovieDetailsRepo {

    override suspend fun getMovieDetails(id: Int): Response<MoviesDetailsResponse> {
        return movieApi.getMoviesDetails(id.toString(), BuildConfig.API_KEY)
    }
}