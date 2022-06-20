package com.mina.moviedetails

import androidx.lifecycle.viewModelScope
import com.mina.common.base.BaseViewModel
import com.mina.moviedetails.domain.GetMoviesDetailsUseCase
import com.mina.moviedetails.intent.MoviesDetailsIntent
import com.mina.moviedetails.state.MoviesDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val getMoviesDetailsUseCase: GetMoviesDetailsUseCase) :
    BaseViewModel<MoviesDetailsState, MoviesDetailsIntent, Any>(MoviesDetailsState()) {

    override suspend fun processIntents(intent: MoviesDetailsIntent) {
        when (intent) {
            is MoviesDetailsIntent.FetchMoviesDetails -> fetchMovieDetails(intent.id)
        }
    }

    private suspend fun fetchMovieDetails(id: Int) {
        try {
            setState { copy(isLoading = true) }
            getMoviesDetailsUseCase.invoke(id).let {
                setState {
                    copy(
                        isLoading = false,
                        movieDetail = it
                    )
                }
            }
        } catch (e: Exception) {
            setState { copy(isLoading = false, errorMessage = e.message) }
        }
    }
}
