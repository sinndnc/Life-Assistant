package com.android.lifeassistant.feature.presentation.main._message

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.navigation.content.Content
import com.android.lifeassistant.feature.presentation.main._message._component.ChatCardComponent
import com.android.lifeassistant.feature.util.extension.noRippleClickable

@Composable
fun MessageContent(viewModel: MessageViewModel, navController: NavController) {

    val listState = rememberLazyListState()
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val searchTextValue = remember { mutableStateOf("") }
    val chatList = viewModel.chatList

    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.noRippleClickable { focusManager.clearFocus() },
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.925f)
                    .statusBarsPadding(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LifeAssistantText(text = "Chats", style = MaterialTheme.typography.h4, fontWeight = FontWeight.SemiBold)
                Icon(Icons.Rounded.MoreVert, contentDescription = "edit")
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            OutlinedTextField(
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .fillMaxWidth(0.925f),
                value = searchTextValue.value,
                onValueChange = { searchTextValue.value = it },
                shape = MaterialTheme.shapes.medium,
                leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = "search ") },
                placeholder = { LifeAssistantText(text = "Search", style = MaterialTheme.typography.body2) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.DarkGray.copy(0.35f),
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        itemsIndexed(chatList) { index, item ->
            val date = item.messages.last().message_date.toDate()
            ChatCardComponent(
                chat_name = item.chat_name,
                chat_date = viewModel.calendarHelper.getTimeOfSpecifiedDate(date),
                last_chat_message = item.messages.last().message
            ) {
                navController.navigate("${Content.Chat.route}/${item.chat_uid}") {

                }
            }
        }
    }
}

