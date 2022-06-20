package com.mina.ui_list.state

import com.mina.common.models.Movie


data class MoviesState(
    val movies: List<Movie> = listOf(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

