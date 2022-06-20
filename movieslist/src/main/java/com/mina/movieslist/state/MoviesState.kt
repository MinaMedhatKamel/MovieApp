package com.mina.movieslist.state

import com.mina.movieslist.data.MovieUi

data class MoviesState(
    val movies: List<MovieUi> = listOf(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val emptyMovies : Boolean = false
)

