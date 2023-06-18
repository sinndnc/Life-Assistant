package com.android.lifeassistant.feature.presentation.main._home._component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.presentation.main._home.HomeViewModel

@Composable
fun ColumnScope.OngoingTaskComponent(homeViewModel: HomeViewModel) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    LazyColumn(
        modifier = Modifier
            .weight(0.8f)
            .fillMaxSize()
    ) {
        items(2) { item ->
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenWidth.dp * 0.250f)
                    .padding(15.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.DarkGray.copy(0.4f)),
            ) {
                Row(
                    modifier = Modifier.weight(0.7f)
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start,
                    ) {
                        LifeAssistantText(text = item.toString())
                        LifeAssistantText(text = item.toString())
                    }
                }
                Box(
                    modifier = Modifier.weight(0.3f),
                    contentAlignment = Alignment.Center
                ) {

                }
            }
        }
    }
}