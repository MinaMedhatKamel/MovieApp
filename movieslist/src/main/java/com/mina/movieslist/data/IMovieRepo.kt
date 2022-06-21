package com.mina.movieslist.data


import retrofit2.Response

interface IMovieRepo {
    suspend fun getTrendingMovies(page:Int): Response<MoviesResponse>
}