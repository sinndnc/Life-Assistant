package com.android.lifeassistant.feature.component.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
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

    val view = LocalView.current

    if (!view.isInEditMode) {
        val currentWindow = (view.context as? Activity)?.window
            ?: throw Exception("Not in an activity - unable to get Window reference")

        SideEffect {
            currentWindow.statusBarColor =  Color.Transparent.toArgb()
            WindowCompat.getInsetsController(currentWindow, view).isAppearanceLightStatusBars = !isDarkTheme
            WindowCompat.getInsetsController(currentWindow, view).isAppearanceLightNavigationBars = !isDarkTheme
        }
    }
    val colors = if (isDarkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}