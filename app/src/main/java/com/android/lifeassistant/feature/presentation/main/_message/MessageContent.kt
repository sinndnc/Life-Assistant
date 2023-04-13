package com.android.lifeassistant.feature.presentation.main._message

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.component.textfield.LifeAssistantTextField
import com.android.lifeassistant.feature.presentation.main._message.component.ChatCardComponent

@Composable
fun MessageContent(viewModel: MessageViewModel, navController: NavController) {

    val listState = rememberLazyListState()
    val searchTextValue = remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier,
        state = listState,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LifeAssistantText(text = "Chats", style = MaterialTheme.typography.h5, fontWeight = FontWeight.Medium)
                Icon(Icons.Rounded.Share, contentDescription = "edit")
            }
        }
        item {
            LifeAssistantTextField(modifier = Modifier.fillMaxWidth(0.9f), value = searchTextValue, label = "Search")
        }
        item {
            repeat(10) {
                Spacer(Modifier.height(10.dp))
                ChatCardComponent()
            }
        }
    }

}

