package com.android.lifeassistant.feature.presentation.main._message._chat._component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.core.domain.model.user.MessageModel
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.presentation.main._message._chat.ChatViewModel
import com.android.lifeassistant.feature.util.extension.noRippleClickable
import kotlinx.coroutines.launch

@Composable
fun ChatNavigationComponent(
    listState: LazyListState,
    chatViewModel: ChatViewModel,
    chatTextValue: MutableState<String>,
) {

    val coroutineScope = rememberCoroutineScope()
    val focusRequester = remember { FocusRequester() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray.copy(0.4f))
            .padding(vertical = 5.dp)
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.925f)
                .focusRequester(focusRequester),
            value = chatTextValue.value,
            onValueChange = { chatTextValue.value = it },
            shape = MaterialTheme.shapes.medium,
            trailingIcon = {
                IconButton(
                    onClick = {
                        val messageModel = MessageModel(message = chatTextValue.value)
                        chatViewModel.sendMessageToChat(messageModel).also {
                            chatTextValue.value = ""
                            coroutineScope.launch {
                                listState.animateScrollToItem(0)
                            }
                        }
                    }
                ) {
                    Icon(Icons.Rounded.Send, contentDescription = "message icon")
                }
            },
            placeholder = { LifeAssistantText(text = "Search", style = MaterialTheme.typography.body2) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colors.onSurface,
                backgroundColor = Color.DarkGray.copy(0.35f),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
    }
}