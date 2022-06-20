package com.mina.moviedetails.domain

import com.mina.moviedetails.data.IMovieDetailsRepo
import com.mina.moviedetails.data.mapToUiModel
import javax.inject.Inject

class GetMoviesDetailsUseCase @Inject constructor(private val repository: IMovieDetailsRepo) {
    suspend operator fun invoke(id:Int) = repository.getMovieDetails(id).body()?.mapToUiModel()
}