package com.mina.movieslist.effects

sealed class MoviesListEffects {
    data class NavigateToDetails(val id: Int) : MoviesListEffects()
}