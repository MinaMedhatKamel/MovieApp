package com.mina.moviedetails.data
import retrofit2.Response

interface IMovieDetailsRepo {
    suspend fun getMovieDetails(id:Int): Response<MoviesDetailsResponse>
}