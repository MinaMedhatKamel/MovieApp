package com.mina.ui_list.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter

import com.mina.common.BuildConfig
import com.mina.common.models.Movie
import com.mina.common.theme.MoviesAppTheme
import com.mina.moviesapp.ui.theme.Pink80
import com.mina.ui_list.MovieListViewModel

@Composable
fun MoviesListScreen(vm: MovieListViewModel = hiltViewModel()) =
    MoviesAppTheme() {
        vm.state.collectAsState().value.let {
            with(it) {
                if (isLoading) LoadingScreen()
                errorMessage?.let { error ->
                    ErrorScreen(error = error)
                }
                if (!movies.isEmpty()) MoviesListScreen(movies = movies, { })

            }
        }
    }


@Composable
fun LoadingScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        //CircularProgressIndicator(color = Pink80)
    }
}

@Composable
fun ErrorScreen(error: String) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Oops, $error!")
    }
}

@Composable
fun MoviesListScreen(movies: List<Movie>, onMovieClick: (Movie) -> Unit) {
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
fun MovieItem(movie: Movie, onMovieClick: (Movie) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .shadow(2.dp)
            .clickable(onClick = {
                onMovieClick(movie)
            })
    ) {
        Image(
            painter = rememberImagePainter(data = "${BuildConfig.IMAGE_URL}${movie.poster_path}"),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}