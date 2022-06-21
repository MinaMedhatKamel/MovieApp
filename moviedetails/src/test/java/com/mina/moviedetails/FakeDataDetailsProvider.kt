package com.mina.moviedetails

import com.mina.common.data.models.Movie
import com.mina.moviedetails.data.MovieDetailsUi
import com.mina.moviedetails.data.MoviesDetailsResponse

import retrofit2.Response

object FakeDataDetailsProvider {
    private val fakeMoviesDetailsUi = MovieDetailsUi(
        id = 2,
        title = "title2",
        imgUrl = "https://image.tmdb.org/t/p/w500 img2",
        "1234",
        description = "test description"

    )

    private val fakeMovie = Movie(
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

    private val fakeMoviesDetailsResponse = MoviesDetailsResponse(
        id = 2,
        vote_count = 2,
        video = false,
        vote_average = 12.00,
        title = "title2",
        popularity = 12.00,
        poster_path = " img2",
        original_language = "",
        original_title = "",
        backdrop_path = "",
        adult = false,
        overview = "test overvoew",
        release_date = "1234",
        belongs_to_collection = "",
        budget = 1,
        homepage = "",
        genres = emptyList(),
        imdb_id = "",
        production_companies = emptyList(),
        production_countries = emptyList(),
        runtime = 1,
        spoken_languages = emptyList(),
        revenue = 1,
        status = "",
        tagline = ""
    )

    fun provideFakeMoviesDetailsUi() = fakeMoviesDetailsUi
    fun provideFakeSuccessMoviesDetailsRepoResponse() = Response.success(fakeMoviesDetailsResponse)


}
