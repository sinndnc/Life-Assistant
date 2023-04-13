package com.android.lifeassistant.feature.presentation.main._home._view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.lifeassistant.feature.presentation.main._home._component.CategoryComponent
import com.android.lifeassistant.feature.presentation.main._home._component.ListComponent

@Composable
fun ColumnScope.CategoryView() {
    Column(
        modifier = Modifier
            .weight(0.5f)
            .fillMaxSize()
    ) {
        ListComponent(categoryName = "Category", categoryCaption = "See all", onClick = {}) {
            CategoryComponent()
        }
    }
}