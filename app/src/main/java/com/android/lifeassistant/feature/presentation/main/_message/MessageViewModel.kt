package com.android.lifeassistant.feature.presentation.main._message

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.android.lifeassistant.core.domain.model.user.ChatModel
import com.android.lifeassistant.core.domain.repostitory.chat.ChatRepository
import com.android.lifeassistant.core.domain.usecase.user.UserUseCase
import com.android.lifeassistant.core.util.calendar.CalendarHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    val calendarHelper: CalendarHelper,
    userUseCase: UserUseCase,
    chatRepository: ChatRepository,
) : ViewModel() {

    val chatList: SnapshotStateList<ChatModel> = chatRepository.chatList

    init {
        userUseCase.invoke()
        chatRepository.getChatsOfUser()
    }

}