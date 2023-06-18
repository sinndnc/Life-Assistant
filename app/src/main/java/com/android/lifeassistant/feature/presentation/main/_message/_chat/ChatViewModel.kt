package com.android.lifeassistant.feature.presentation.main._message._chat

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lifeassistant.core.domain.mapper.toUserModelUi
import com.android.lifeassistant.core.domain.model.notification.DataModel
import com.android.lifeassistant.core.domain.model.notification.NotificationModel
import com.android.lifeassistant.core.domain.model.user.MessageModel
import com.android.lifeassistant.core.domain.model.user.UserModelUi
import com.android.lifeassistant.core.domain.repostitory.chat.ChatRepository
import com.android.lifeassistant.core.domain.repostitory.user.UserRepository
import com.android.lifeassistant.core.domain.usecase.user.UserUseCase
import com.android.lifeassistant.core.util.calendar.CalendarHelper
import com.android.lifeassistant.feature.util.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    val calendarHelper: CalendarHelper,
    savedStateHandle: SavedStateHandle,
    private val userUseCase: UserUseCase,
    private val chatRepository: ChatRepository,
    private val userRepository: UserRepository,
) : ViewModel() {

    val chatUid: String = checkNotNull(savedStateHandle["userId"])

    private val _uiState = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    private val _currentUserModel = mutableStateOf(userUseCase.currentUserModel.value)
    val currentUserModel: MutableState<UserModelUi> = _currentUserModel

    private val _chatUserModel = mutableStateOf(UserModelUi())
    val chatUserModel: MutableState<UserModelUi> = _chatUserModel

    private val _chatMessagesList = MutableStateFlow(listOf<MessageModel>())
    val chatMessagesList: StateFlow<List<MessageModel>> = _chatMessagesList

    private val _chatTextValue: MutableState<String> = mutableStateOf("")
    val chatTextValue: MutableState<String> = _chatTextValue

    init {
        chatRepository.getMessagesOfChat(chatUid).onEach { responseState ->
            responseState
                .onLoading {
                    _uiState.value = UiState.Loading
                }.onSuccess { messagesList ->
                    _chatMessagesList.value = messagesList
                    _uiState.value = UiState.Success
                    _chatUserModel.value = userRepository.getUserByUid(chatUid).toUserModelUi()
                }.onError {

                }
        }.launchIn(viewModelScope)
    }

    fun sendMessageToChat(messageModel: MessageModel) {
        val title = currentUserModel.value.name
        val date = messageModel.message_date.toDate()
        val notificationId = (date.time / 1000).toInt()
        val newMessageModel = messageModel.apply { sender_uid = currentUserModel.value.uid }
        val dataModel = DataModel(body = messageModel.message, title = title, id = notificationId, userId = chatUserModel.value.uid)
        val notificationModel = NotificationModel(to = currentUserModel.value.token, data = dataModel)
        chatRepository.sendMessageToChat(chatUid = chatUid, messageModel = newMessageModel, notificationModel = notificationModel)
    }


}