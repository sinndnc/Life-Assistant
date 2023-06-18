package com.android.lifeassistant.feature.presentation.main._message._component

import LifeAssistant.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.core.domain.model.util.TimeModel
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.component.theme.Blue500
import com.android.lifeassistant.feature.component.theme.Gray500

@Composable
fun ChatCardComponent(
    chat_name: String,
    chat_date: TimeModel,
    last_chat_message: String,
    onClick: () -> Unit,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight * 0.1f)
            .clickable { onClick() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            modifier = Modifier.weight(0.175f)
        ) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "image circle"
            )
        }
        Column(
            modifier = Modifier
                .weight(0.825f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LifeAssistantText(
                    modifier = Modifier.weight(0.875f),
                    text = chat_name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold
                )
                LifeAssistantText(
                    modifier = Modifier.weight(0.125f),
                    text = "${chat_date.hour}:${chat_date.minute}",
                    style = MaterialTheme.typography.body2,
                    color = Gray500.copy(0.99f)
                )
            }
            Row(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LifeAssistantText(
                    modifier = Modifier.weight(0.9f),
                    text = last_chat_message,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Box(
                    modifier = Modifier
                        .weight(0.1f)
                        .clip(CircleShape)
                        .background(Blue500.copy(0.4f)),
                    contentAlignment = Alignment.Center
                ) {
                    LifeAssistantText(text = "1")
                }
            }
        }
    }
    Divider(color = Color.DarkGray.copy(0.5f), thickness = 1.dp)
}