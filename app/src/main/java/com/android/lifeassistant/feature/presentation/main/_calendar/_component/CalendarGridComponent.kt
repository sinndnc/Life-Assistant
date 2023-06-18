package com.android.lifeassistant.feature.presentation.main._calendar._component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalendarGridComponent() {

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp.dp * 0.3f
    val height = configuration.screenHeightDp.dp * 0.05f



    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .border((1 * 0.56).dp, Color.Gray.copy(0.7f)),
        contentAlignment = Alignment.Center,
    ) {

    }
}

@Preview
@Composable
fun CalendarGridComponentPreview() {
    CalendarGridComponent()
}