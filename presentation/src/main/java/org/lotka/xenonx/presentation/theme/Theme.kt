package org.lotka.xenonx.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = BlueAccent,
    background = DarkGray,
    onBackground = Color.White,
    onPrimary = DarkGray,
    surface = MediumGray
    , onSurface = LightGray,
    secondary = Yellow
)

@Composable
fun CleanArchitectureMovieAppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}