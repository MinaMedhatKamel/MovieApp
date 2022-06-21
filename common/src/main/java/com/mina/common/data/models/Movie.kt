package com.mina.common.data.models

import android.os.Parcelable

import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var id: Int,
    var vote_count: Int,
    var video: Boolean,
    val vote_average: Double,
    val title: String?,
    val popularity: Double,
    val poster_path: String?,
    val original_language: String?,
    val original_title: String?,
    val backdrop_path: String? = "null",
    var adult: Boolean = false,
    val overview: String?,
    val release_date: String?
) : Parcelable
