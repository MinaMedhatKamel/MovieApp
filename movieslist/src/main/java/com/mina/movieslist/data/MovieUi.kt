package com.mina.movieslist.data

import com.mina.common.data.models.Movie
import com.mina.common.BuildConfig

data class MovieUi(val id: Int, val title: String, val imgUrl: String, val year: String)
data class MovieUiPagingModel(val data : List<MovieUi>,val page :Int)

fun Movie.mapToUiModel(): MovieUi = MovieUi(
    this.id,
    this.title ?: "No title error",
    BuildConfig.IMAGE_URL + this.poster_path,
    this.release_date?.take(4).toString()
)

