package com.mina.movieslist

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mina.common.base.BaseViewModel
import com.mina.movieslist.data.IMovieRepo
import com.mina.movieslist.data.MovieUi
import com.mina.movieslist.domain.GetMoviesUseCase
import com.mina.movieslist.effects.MoviesListEffects
import com.mina.movieslist.intent.MoviesIntent
import com.mina.movieslist.paging.MovieSource
import com.mina.movieslist.state.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    BaseViewModel<MoviesState, MoviesIntent, MoviesListEffects>(MoviesState()) {

    val movies: Flow<PagingData<MovieUi>> = Pager(PagingConfig(pageSize = 6)) {
        MovieSource(getMoviesUseCase)
    }.flow.cachedIn(viewModelScope)

    override suspend fun processIntents(intent: MoviesIntent) {
        when (intent) {
            MoviesIntent.FetchMovies -> fetchMovies()
            is MoviesIntent.NavigateToDetails -> navigateToDetails(intent.id)
        }
    }

    private suspend fun navigateToDetails(id: Int) {
        sendEffect(MoviesListEffects.NavigateToDetails(id))
    }

    init {
        sendAction(MoviesIntent.FetchMovies)
    }

    private suspend fun fetchMovies2() {
        movies.collectas
    }

    private suspend fun fetchMovies() {

        try {
            setState { copy(isLoading = true) }
            getMoviesUseCase.invoke(1).let {
                if (it.data.isNotEmpty()) {
                    setState {
                        copy(
                            isLoading = false,
                            movies = it.data
                        )
                    }
                } else {
                    setState {
                        copy(
                            isLoading = false,
                            emptyMovies = true
                        )
                    }
                }
            }
        } catch (e: Exception) {
            setState { copy(isLoading = false, errorMessage = e.message) }
        }
    }
}
