package com.android.lifeassistant.feature.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun LifeAssistantText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = TextStyle.Default,
    fontWeight: FontWeight = FontWeight.Normal,
    overflow: TextOverflow = TextOverflow.Clip,
    color: Color = MaterialTheme.colors.onSurface,
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        maxLines = maxLines,
        fontWeight = fontWeight,
        overflow = overflow
    )
}