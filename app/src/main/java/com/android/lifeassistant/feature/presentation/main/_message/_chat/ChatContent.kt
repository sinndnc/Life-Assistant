package com.android.lifeassistant.feature.presentation.main._message._chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import com.android.lifeassistant.feature.presentation.main._message._chat._component.ChatBarComponent
import com.android.lifeassistant.feature.presentation.main._message._chat._component.ChatBarListComponent
import com.android.lifeassistant.feature.presentation.main._message._chat._component.ChatNavigationComponent
import com.android.lifeassistant.feature.util.extension.noRippleClickable
import com.android.lifeassistant.feature.util.state.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun ChatContent(navController: NavController, chatViewModel: ChatViewModel) {

    val listState = rememberLazyListState()
    val focusManager = LocalFocusManager.current
    val uiState = chatViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .imePadding()
            .noRippleClickable { focusManager.clearFocus() }
    ) {
        ChatBarComponent(navController = navController, chatViewModel = chatViewModel)
        when (uiState.value) {
            UiState.Loading -> LoadingScreen()
            else -> ChatBarListComponent(listState = listState, chatViewModel = chatViewModel)
        }
        ChatNavigationComponent(
            listState = listState,
            chatViewModel = chatViewModel,
            chatTextValue = chatViewModel.chatTextValue,
        )
    }
}


@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}