package com.android.lifeassistant.feature.component.bubble

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.core.domain.model.user.MessageModel
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.component.theme.Gray500
import com.android.lifeassistant.feature.component.triangle.TriangleLeftEdgeShape
import com.android.lifeassistant.feature.presentation.main._message._chat.ChatViewModel
import kotlin.time.Duration.Companion.hours

@Composable
fun ChatLeftBubbleComponent(
    isSelected: Boolean,
    message: MessageModel,
    viewModel: ChatViewModel,
    onClick: (message: MessageModel) -> Unit
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val time = viewModel.calendarHelper.getTimeOfSpecifiedDate(message.message_date.toDate())

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .selectable(selected = isSelected) { onClick(message) }
            .background(if(isSelected) Color.DarkGray else MaterialTheme.colors.surface)
            .padding(4.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Row(
            Modifier
                .height(IntrinsicSize.Max)
                .widthIn(min = 0.dp, max = screenWidth.dp * 0.8f)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Gray500.copy(0.4f),
                        shape = TriangleLeftEdgeShape()
                    )
                    .width(8.dp)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .background(
                        color = Gray500.copy(0.4f),
                        shape = RoundedCornerShape(8.dp, 8.dp, 8.dp, 0.dp)
                    )
                    .padding(5.dp)
                    .wrapContentWidth()
            ) {
                LifeAssistantText(text = message.message, style = MaterialTheme.typography.body2)
            }
        }
        LifeAssistantText(text = "${time.hour}:${time.minute}", style = MaterialTheme.typography.overline)
    }

}