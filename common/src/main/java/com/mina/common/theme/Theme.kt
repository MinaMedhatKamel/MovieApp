package com.mina.common.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorPalette = lightColors(
    primary = Purple80,
    secondary = PurpleGrey80,
    background = Pink80,
    surface = Color.White.copy(alpha = .85f),
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val DarkColorPalette = darkColors(
    primary = Purple40,
    secondary = PurpleGrey40,
    background = Pink40,
    surface = Color.White.copy(alpha = 0.15f),
    onSurface = Color.White.copy(alpha = .8f)
)

@Composable
fun MoviesAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}
