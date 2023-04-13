package com.android.lifeassistant.feature.presentation.main._home._component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.text.LifeAssistantText

@Composable
fun ColumnScope.ListComponent(
    categoryName: String,
    categoryCaption: String,
    onClick: () -> Unit,
    component: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier
            .weight(0.2f)
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LifeAssistantText(
            text = categoryName,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.SemiBold
        )
        LifeAssistantText(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .clickable { onClick() },
            text = categoryCaption,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.secondary,
        )
    }
    component()

}
