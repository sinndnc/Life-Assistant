package com.android.lifeassistant.feature.presentation.main._home._view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.text.LifeAssistantText

@Composable
fun ColumnScope.ProfileView(
    profileName : String,
    onGoingTasks : Int,
    profileImage: Int,
) {
        Row(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                LifeAssistantText(profileName, style = MaterialTheme.typography.h6, fontWeight = FontWeight.Medium)
                LifeAssistantText(text = "$onGoingTasks tasks are waiting for you today", style = MaterialTheme.typography.caption)
            }
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxSize(), contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painterResource(id = profileImage),
                    modifier = Modifier
                        .fillMaxSize(0.45f),
                    contentDescription = "profile Image"
                )
            }
        }

}