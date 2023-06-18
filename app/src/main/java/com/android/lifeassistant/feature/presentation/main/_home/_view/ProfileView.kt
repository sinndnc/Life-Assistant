package com.android.lifeassistant.feature.presentation.main._home._view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.presentation.main._home.HomeViewModel

@Composable
fun ColumnScope.ProfileView(homeViewModel: HomeViewModel) {

    val userModel = homeViewModel.userModel.collectAsState()

    Row(
        modifier = Modifier
            .weight(0.5f)
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(0.85f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            LifeAssistantText(userModel.value.name, style = MaterialTheme.typography.h6, fontWeight = FontWeight.Medium)
            LifeAssistantText(text = "1 tasks are waiting for you today", style = MaterialTheme.typography.caption)
        }
        Box(
            modifier = Modifier
                .weight(0.15f)
                .fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ) {
            userModel.value.image?.asImageBitmap()?.let {
                Image(
                    bitmap = it,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    contentDescription = "profile Image",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(55.dp),
                )
            }

        }
    }

}