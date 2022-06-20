package com.mina.moviedetails.intent

sealed class MoviesDetailsIntent() {
    class FetchMoviesDetails(val id: Int) : MoviesDetailsIntent()
}