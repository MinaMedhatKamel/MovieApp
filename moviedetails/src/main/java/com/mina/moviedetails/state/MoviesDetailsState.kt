package com.mina.moviedetails.state

import com.mina.moviedetails.data.MovieDetailsUi


data class MoviesDetailsState(
    val movieDetail: MovieDetailsUi? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

