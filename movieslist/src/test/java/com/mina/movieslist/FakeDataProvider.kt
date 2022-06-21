package com.mina.movieslist

import com.mina.common.data.models.Movie
import com.mina.movieslist.data.MovieUi
import com.mina.movieslist.data.MoviesResponse
import retrofit2.Response
object FakeDataProvider {
    private val fakeMoviesUiList = listOf(
        MovieUi(
            id = 1, title = "title", imgUrl = "https://image.tmdb.org/t/p/w500 img", "123"
        ), MovieUi(
            id = 2, title = "title2", imgUrl = "https://image.tmdb.org/t/p/w500 img2", "1234"
        )
    )

    private val fakeMoviesList = listOf<Movie>(
        Movie(
            id = 1,
            vote_count = 2,
            video = false,
            vote_average = 12.00,
            title = "title",
            popularity = 12.00,
            poster_path = " img",
            original_language = null,
            original_title = null,
            backdrop_path = null,
            adult = false,
            overview = "test overvoew",
            release_date = "123"
        ), Movie(
            id = 2,
            vote_count = 2,
            video = false,
            vote_average = 12.00,
            title = "title2",
            popularity = 12.00,
            poster_path = " img2",
            original_language = null,
            original_title = null,
            backdrop_path = null,
            adult = false,
            overview = "test overvoew",
            release_date = "1234"
        )
    )

    private val fakeMoviesResponse = MoviesResponse(
        page = 1, total_results = 10, total_pages = 10, results = fakeMoviesList
    )

    fun provideFakeMoviesUiList() = fakeMoviesUiList
    fun provideFakeSuccessMoviesRepoResponse() = Response.success(fakeMoviesResponse)


}
