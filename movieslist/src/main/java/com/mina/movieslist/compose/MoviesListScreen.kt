package com.mina.movieslist.compose


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.mina.common.R
import com.mina.common.composeUi.ErrorScreen
import com.mina.common.composeUi.HeaderSection
import com.mina.common.composeUi.LoadingScreen
import com.mina.common.theme.MoviesAppTheme
import com.mina.moviesapp.ui.theme.whiteTransparent
import com.mina.movieslist.MovieListViewModel
import com.mina.movieslist.data.MovieUi
import com.mina.movieslist.effects.MoviesListEffects
import com.mina.movieslist.intent.MoviesIntent
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.flow.Flow

@Composable
fun MoviesListScreen(goToDetails: (i: Int) -> Unit, vm: MovieListViewModel = hiltViewModel()) =
    MoviesAppTheme() {
        Scaffold(topBar =
        { TopAppBar(title = { Text(stringResource(R.string.app_bar_title)) }) }) {
            val state = vm.state.collectAsState().value
            if (state.isLoading) LoadingScreen()
            if (state.emptyMovies) ErrorScreen(error = stringResource(id = R.string.empty_movies_error))
            MoviesListScreen(movies = state.movies) {
                vm.sendAction(
                    MoviesIntent.NavigateToDetails(
                        it
                    )
                )
            }

            LaunchedEffect(true) {
                vm.effects.collect {
                    when (it) {
                        is MoviesListEffects.NavigateToDetails -> goToDetails(it.id)
                    }
                }
            }
        }
    }


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesListScreen(movies: Flow<PagingData<MovieUi>>, onMovieClick: (Int) -> Unit) {
    val lazyMovieItems = movies.collectAsLazyPagingItems()

    LazyVerticalGrid(
        cells = GridCells.Fixed(2), verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(lazyMovieItems.itemCount) { index ->
            MovieItem(movie = lazyMovieItems[index]!!, onMovieClick)
        }
    }
}

@Composable
fun MovieItem(movie: MovieUi, onMovieClick: (Int) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .shadow(2.dp)
            .clickable(onClick = {
                onMovieClick(movie.id)
            })
    ) {
        Box() {

            GlideImage(
                imageModel = movie.imgUrl,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
                // shows a placeholder while loading the image.
                placeHolder = ImageBitmap.imageResource(R.drawable.movie_ph),
                // shows an error ImageBitmap when the request failed.
            )

            HeaderSection(
                title = movie.title,
                year = movie.year,
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd),
                whiteTransparent
            )

        }
    }
}

