package com.mina.common.composeUi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mina.moviesapp.ui.theme.bodyMedium20
import com.mina.moviesapp.ui.theme.titleLarge
import com.mina.moviesapp.ui.theme.whiteTransparent

@Composable
fun HeaderSection(title: String, year: String, modifier: Modifier, color: Color = Color.White) {
    Card(elevation = 1.dp, backgroundColor = color, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            //title
            Text(
                text = title,
                style = titleLarge
            )
            //year
            Text(
                text = year,
                style = bodyMedium20, modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}
