package com.mina.ui_list.data


import com.mina.common.models.Movie
import retrofit2.Response

interface IMovieRepo {
    suspend fun getTrendingMovies(): Response<MoviesResponse>
}