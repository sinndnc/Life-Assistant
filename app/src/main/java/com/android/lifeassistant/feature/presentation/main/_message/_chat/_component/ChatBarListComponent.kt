package com.android.lifeassistant.feature.presentation.main._message._chat._component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.android.lifeassistant.core.domain.model.user.MessageModel
import com.android.lifeassistant.feature.component.bubble.ChatLeftBubbleComponent
import com.android.lifeassistant.feature.component.bubble.ChatRightBubbleComponent
import com.android.lifeassistant.feature.presentation.main._message._chat.ChatViewModel

@Composable
fun ColumnScope.ChatBarListComponent(
    listState: LazyListState,
    chatViewModel: ChatViewModel,
) {

    val messages = chatViewModel.chatMessagesList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
        state = listState,
        reverseLayout = true,
    ) {
        itemsIndexed(messages.value) { index, item ->
            if (item.sender_uid == chatViewModel.chatUid) {
                ChatLeftBubbleComponent(item.isSelected, item, chatViewModel) {
                    item.isSelected = !item.isSelected
                }
            } else {
                ChatRightBubbleComponent(item.isSelected, item, chatViewModel) {
                    item.isSelected = !item.isSelected
                }
            }
        }
    }
}