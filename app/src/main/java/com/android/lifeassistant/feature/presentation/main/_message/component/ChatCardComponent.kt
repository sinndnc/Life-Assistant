package com.android.lifeassistant.feature.presentation.main._message.component

import LifeAssistant.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.text.LifeAssistantText

@Composable
fun ChatCardComponent() {
    Row(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.weight(0.20f)) {
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "image circle"
            )
        }
        Column(
            modifier = Modifier.weight(0.7f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            LifeAssistantText("Yuri Yeager")
            LifeAssistantText("can you confirm deadline")

        }
        LifeAssistantText(modifier = Modifier.weight(0.1f), text = "20 min")
    }
}