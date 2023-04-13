package com.android.lifeassistant.feature.presentation.main._home._component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.theme.Pink100
import com.android.lifeassistant.feature.component.theme.Pink200
import com.android.lifeassistant.feature.component.theme.Pink50

@Composable
fun ColumnScope.CategoryComponent() {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val brush = Brush.linearGradient(listOf(Pink200, Pink100, Pink50, Color.White, Color.White, Color.White))

    LazyRow(
        modifier = Modifier
            .weight(0.8f)
            .fillMaxSize()
    ) {
        items(5) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .width(screenWidth.dp * 0.45f)
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.medium)
                    .background(brush),
                contentAlignment = Alignment.Center
            ) {
                Text(text = it.toString())
            }
        }
    }
}