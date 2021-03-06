package com.mina.movieslist.data


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    companion object {
        const val TRENDING_MOVIES_QUERY: String = ("discover/movie?sort_by=popularity.desc")
        const val API_KEY_QUERY: String = "api_key"
        const val PAGE_QUERY: String = "page"
    }

    @GET(TRENDING_MOVIES_QUERY)
    suspend fun getTrendingMovies(@Query(API_KEY_QUERY) apiKey: String,@Query(PAGE_QUERY) page: Int): Response<MoviesResponse>

}
