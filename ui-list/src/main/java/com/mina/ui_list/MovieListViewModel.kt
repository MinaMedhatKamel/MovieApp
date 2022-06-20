package com.mina.ui_list

import androidx.lifecycle.viewModelScope
import com.mina.common.base.BaseViewModel
import com.mina.ui_list.data.IMovieRepo
import com.mina.ui_list.intent.MoviesIntent
import com.mina.ui_list.state.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: IMovieRepo) :
    BaseViewModel<MoviesState, MoviesIntent>(MoviesState()) {

    override fun processIntents(intent: MoviesIntent) {
        viewModelScope.launch() {
            when (intent) {
                MoviesIntent.FetchMovies -> fetchMovies()
            }
        }
    }

    init {
        sendAction(MoviesIntent.FetchMovies)
    }

    private suspend fun fetchMovies() {
        try {
            setState { copy(isLoading = true) }
            repository.getTrendingMovies().body()?.results?.let {
                setState {
                    copy(
                        isLoading = false,
                        movies = it
                    )
                }
            }
        } catch (e: Exception) {
            setState { copy(isLoading = false, errorMessage = e.message) }
        }
    }
}
