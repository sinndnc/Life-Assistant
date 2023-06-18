package com.android.lifeassistant.feature.presentation.main._calendar._component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.text.LifeAssistantText

@Composable
fun HourComponent(hour: String) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp.dp * 0.175f
    val height = configuration.screenHeightDp.dp * 0.05f

    Box(
        modifier = Modifier
            .width(width)
            .height(height),
        contentAlignment = Alignment.TopCenter,
    ) {
        LifeAssistantText(
            text = hour,
            color = Color.LightGray,
            style = MaterialTheme.typography.overline
        )
    }
}

@Preview
@Composable
fun HourComponentPreview() {
    HourComponent(hour = "1 AM")
}