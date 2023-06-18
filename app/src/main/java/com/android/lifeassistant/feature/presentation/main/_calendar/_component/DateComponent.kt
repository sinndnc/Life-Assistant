package com.android.lifeassistant.feature.presentation.main._calendar._component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.component.theme.Black500

@Composable
fun DateComponent(day: String) {

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp.dp * 0.3f
    val height = configuration.screenHeightDp.dp * 0.05f

    Box(
        modifier = Modifier
            .width(width)
            .height(height),
        contentAlignment = Alignment.Center,
    ) {
        LifeAssistantText(
            text = day,
            color = Color.LightGray,
            modifier = Modifier
                .background(Color.LightGray.copy(0.25f), MaterialTheme.shapes.medium)
                .padding(5.dp),
            style = MaterialTheme.typography.caption
        )
    }
}


@Preview
@Composable
fun DateComponentPreview() {
    DateComponent("mon")
}
