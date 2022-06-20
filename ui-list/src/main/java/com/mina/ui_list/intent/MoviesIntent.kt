package com.mina.ui_list.intent

sealed class MoviesIntent {
    object FetchMovies : MoviesIntent()
}