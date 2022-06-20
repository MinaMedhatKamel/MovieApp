package com.mina.movieslist.domain

import com.mina.movieslist.data.IMovieRepo
import com.mina.movieslist.data.mapToUiModel
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: IMovieRepo) {
    suspend operator fun invoke() = repository.getTrendingMovies().body()?.results?.map {
        it.mapToUiModel()
    } ?: emptyList()
}