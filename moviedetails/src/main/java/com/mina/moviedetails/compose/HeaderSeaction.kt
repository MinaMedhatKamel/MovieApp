package com.mina.moviedetails.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mina.moviedetails.data.MovieDetailsUi
import com.mina.moviesapp.ui.theme.bodyMedium20
import com.mina.moviesapp.ui.theme.titleLarge

@Composable
fun HeaderSection(movie: MovieDetailsUi) {
    Card(elevation = 1.dp, backgroundColor = Color.White) {
        Column(Modifier.padding(8.dp)) {
            //title
            Text(
                text = movie.title,
                style = titleLarge
            )
            //year
            Text(
                text = movie.year,
                style = bodyMedium20, modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}
