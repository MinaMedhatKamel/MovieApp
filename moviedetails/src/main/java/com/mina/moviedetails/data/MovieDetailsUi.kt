package com.mina.moviedetails.data

import com.mina.common.BuildConfig

data class MovieDetailsUi(
    val id: Int,
    val title: String,
    val imgUrl: String,
    val year: String,
    val description: String
)

fun MoviesDetailsResponse.mapToUiModel(): MovieDetailsUi = MovieDetailsUi(
    this.id,
    this.title ?: "No title error",
    BuildConfig.IMAGE_URL + this.poster_path,
    this.release_date?.take(4).toString(), this.overview
)