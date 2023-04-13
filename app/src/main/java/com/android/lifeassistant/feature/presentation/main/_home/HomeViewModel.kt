package com.android.lifeassistant.feature.presentation.main._home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.model.util.TaskModel
import com.android.lifeassistant.core.domain.repostitory.StorageRepository
import com.android.lifeassistant.core.util.calendar.CalendarHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val calendarHelper: CalendarHelper,
    private val storageRepository: StorageRepository,
) : ViewModel() {

    val currentCalendar = calendarHelper.getCurrentDayInMonth
    val daysInMonth = calendarHelper.getDaysInMonth()

    init {
        getOnGoingTaskList()
    }

    val currentUser: MutableState<UserModelApi> = mutableStateOf(UserModelApi())

    private val _onGoingTaskList: SnapshotStateList<TaskModel> = mutableStateListOf()
    val onGoingTaskList: SnapshotStateList<TaskModel> = _onGoingTaskList

    private fun getOnGoingTaskList() {
        storageRepository.getCurrentUser().onEach { state ->
            state.onLoading {

            }.onSuccess {
                currentUser.value = it
                onGoingTaskList.addAll(it.tasks)
            }.onError {

            }
        }.launchIn(viewModelScope)
    }
}
