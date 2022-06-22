package com.mina.moviedetails.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mina.moviedetails.data.MovieDetailsUi
import com.mina.common.theme.bodyMedium

@Composable
fun DescriptionSection(movie: MovieDetailsUi) {
    Card(elevation = 1.dp, backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(8.dp)) {
            //year
            Text(
                text = movie.description,
                style = bodyMedium, modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}
