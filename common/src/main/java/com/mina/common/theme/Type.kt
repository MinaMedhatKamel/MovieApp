package com.mina.moviesapp.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val titleLarge = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
    color = Color.Black
)
val titleLargeError = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
    color = Color.Red
)

val bodyMedium = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
    color = Color.Black
)
val bodyMedium20 = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
    color = Color.Black
)
val labelSmall = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp,
    color = Color.Black
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = titleLarge,
    h2 = bodyMedium,
    h3 = labelSmall
)