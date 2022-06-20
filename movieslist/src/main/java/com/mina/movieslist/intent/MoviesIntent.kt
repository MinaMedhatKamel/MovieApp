package com.mina.movieslist.intent

sealed class MoviesIntent {
    object FetchMovies : MoviesIntent()
    data class NavigateToDetails(val id: Int) : MoviesIntent()
}