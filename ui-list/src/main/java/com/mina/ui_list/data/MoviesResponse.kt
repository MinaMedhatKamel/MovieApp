package com.mina.ui_list.data

import android.os.Parcelable
import com.mina.common.models.Movie
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesResponse(
    var page: Int?,
    var total_results: Int?,
    var total_pages: Int,
    var results: List<Movie>
) : Parcelable