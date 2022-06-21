package com.mina.movieslist.compose


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
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
import kotlinx.coroutines.flow.collect

@Composable
fun MoviesListScreen(goToDetails: (i: Int) -> Unit, vm: MovieListViewModel = hiltViewModel()) =
    MoviesAppTheme() {
        Scaffold(topBar =
        { TopAppBar(title = { Text("Movies") }) }) {

            vm.state.collectAsState().value.let {
                with(it) {
                    if (isLoading) LoadingScreen()
                    if (emptyMovies) ErrorScreen(error = stringResource(id = com.mina.movieslist.R.string.empty_movies_error))
                    errorMessage?.let { error ->
                        ErrorScreen(error = error)
                    }
                    if (!movies.isEmpty()) MoviesListScreen(
                        movies = movies
                    ) { vm.sendAction(MoviesIntent.NavigateToDetails(it)) }
                }
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


@Composable
fun MoviesListScreen(movies: List<MovieUi>, onMovieClick: (Int) -> Unit) {
    val rowSize = 2
    LazyColumn() {
        items(items = movies.chunked(rowSize)) { row ->
            Row(
                Modifier
                    .fillParentMaxWidth()
                    .fillParentMaxHeight(.5f),
            ) {
                for ((index, item) in row.withIndex()) {
                    Box(
                        Modifier
                            .fillMaxWidth(1f / (rowSize - index))
                            .padding(1.dp)
                    ) {
                        MovieItem(item, onMovieClick)
                    }
                }
            }
        }
    }
}


@Composable
fun MovieList(movies: Flow<PagingData<MovieUi>>) {
    val lazyMovieItems = movies.collectAsLazyPagingItems()

    LazyColumn {

        items(lazyMovieItems) { movie ->
            MovieItem(movie = movie!!)
        }

        lazyMovieItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = lazyMovieItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazyMovieItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
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
                Modifier.fillMaxWidth().align(Alignment.BottomEnd),
                whiteTransparent
            )

        }
    }
}

