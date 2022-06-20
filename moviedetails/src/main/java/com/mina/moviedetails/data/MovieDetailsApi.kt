package com.mina.moviedetails.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApi {
    companion object {
        const val API_KEY_QUERY: String = "api_key"
        const val MOVIE_DETAILS_QUERY: String = "movie/{movie_id}"
        const val MOVIE_ID_PATH: String = "movie_id"
    }

    @GET(MOVIE_DETAILS_QUERY)
    suspend fun getMoviesDetails(
        @Path(MOVIE_ID_PATH) movieId: String,
        @Query(API_KEY_QUERY) apiKey: String
    ): Response<MoviesDetailsResponse>

}
