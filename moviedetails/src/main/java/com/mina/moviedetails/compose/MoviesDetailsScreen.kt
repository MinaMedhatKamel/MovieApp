package com.mina.moviedetails.compose

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mina.common.R
import com.mina.common.composeUi.ErrorScreen
import com.mina.common.composeUi.HeaderSection
import com.mina.common.composeUi.LoadingScreen
import com.mina.common.composeUi.SectionSeprator
import com.mina.common.theme.MoviesAppTheme
import com.mina.moviedetails.MovieDetailsViewModel
import com.mina.moviedetails.data.MovieDetailsUi
import com.mina.moviedetails.intent.MoviesDetailsIntent
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MoviesDetailsScreen(
    goBack: () -> Unit,
    movieId: Int,
    vm: MovieDetailsViewModel = hiltViewModel()
) {
    fun finished() {
        goBack()
    }

    MoviesAppTheme() {
        vm.sendAction(MoviesDetailsIntent.FetchMoviesDetails(movieId))
        vm.state.collectAsState().value.let {
            with(it) {
                if (isLoading) LoadingScreen()
                errorMessage?.let { error ->
                    ErrorScreen(error = error)
                }

                if (movieDetail != null) MoviesDetails(movie = movieDetail, goBack)
            }
        }
    }

    BackHandler(true, ::finished)
}

@Composable
fun MoviesDetails(movie: MovieDetailsUi, goBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            GlideImage(
                imageModel = movie.imgUrl,
                contentScale = ContentScale.Crop,
                placeHolder = ImageBitmap.imageResource(R.drawable.movie_ph),
            )

            HeaderSection(movie.title, movie.year, Modifier.fillMaxWidth())
            SectionSeprator()
            DescriptionSection(movie)

        }
    }


}

