package com.android.lifeassistant.feature.presentation.main._message._chat._component

import LifeAssistant.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.presentation.main._message._chat.ChatViewModel

@Composable
fun ChatBarComponent(chatViewModel: ChatViewModel,navController: NavController) {

    val configuration = LocalConfiguration.current
    val deviceHeight = configuration.screenHeightDp
    val deviceWidth = configuration.screenWidthDp

    Row(
        modifier = Modifier
            .height(deviceHeight.dp * 0.125f)
            .fillMaxWidth()
            .background(Color.DarkGray.copy(0.4f))
            .statusBarsPadding()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(0.190f)
                .clip(RoundedCornerShape(20.dp))
                .clickable { navController.popBackStack() },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.ArrowBack,
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .size(25.dp)
                    .padding(2.dp),
                contentDescription = "chat back icon"
            )
            Image(
                painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit,
                contentDescription = "chat image"
            )
        }
        Box(
            modifier = Modifier.weight(0.8f),
            contentAlignment = Alignment.Center
        ) {
            LifeAssistantText(text = "Ediz", style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Medium)
        }
        Icon(
            Icons.Rounded.Info,
            tint = MaterialTheme.colors.onSurface,
            contentDescription = "chat info",
            modifier = Modifier.weight(0.175f)
        )
    }
}