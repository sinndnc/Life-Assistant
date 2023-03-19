package com.android.lifeassistant.feature.component.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.android.lifeassistant.core.util.theme.ThemeState
import com.android.lifeassistant.feature.component.theme.palette.DarkColorPalette
import com.android.lifeassistant.feature.component.theme.palette.LightColorPalette

@Composable
fun LifeAssistantTheme(theme: ThemeState, content: @Composable () -> Unit) {

    val isDarkTheme: Boolean = when (theme) {
        ThemeState.Dark -> true
        ThemeState.Light -> false
        ThemeState.System -> isSystemInDarkTheme()
    }

    val colors = if (isDarkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}