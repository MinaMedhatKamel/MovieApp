package com.mina.movieslist.state

import androidx.paging.PagingData
import com.mina.movieslist.data.MovieUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MoviesState(
    val movies: Flow<PagingData<MovieUi>> = emptyFlow(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val emptyMovies: Boolean = false
)

