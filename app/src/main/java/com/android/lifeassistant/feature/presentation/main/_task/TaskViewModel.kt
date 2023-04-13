package com.android.lifeassistant.feature.presentation.main._task

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lifeassistant.core.domain.model.util.CalendarModel
import com.android.lifeassistant.core.domain.model.util.TaskModel
import com.android.lifeassistant.core.domain.repostitory.StorageRepository
import com.android.lifeassistant.core.util.calendar.CalendarHelper
import com.google.firebase.Timestamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val calendarHelper: CalendarHelper,
    private val storageRepository: StorageRepository,
) : ViewModel() {

    val currentCalendar = calendarHelper.getCurrentDayInMonth
    val daysInMonth = calendarHelper.getDaysInMonth()

    private val _taskNameState: MutableState<String> = mutableStateOf("")
    val taskNameState: MutableState<String> = _taskNameState

    private val _taskDescriptionState: MutableState<String> = mutableStateOf("")
    val taskDescriptionState: MutableState<String> = _taskDescriptionState

    private val _selectedDayList: SnapshotStateList<CalendarModel> = mutableStateListOf()
    val selectedDayList: SnapshotStateList<CalendarModel> = _selectedDayList

    fun selectCalendarDay(day: CalendarModel) {
        if (_selectedDayList.find { it == day } == null) {
            _selectedDayList.add(day)
        } else {
            _selectedDayList.remove(day)
        }
    }

    fun timeOnStartPressed() {
    }

    fun timeOnFinishPressed() {

    }

    suspend fun calendarOnBackPressed(calendarListState: LazyListState) {
        if (calendarListState.firstVisibleItemIndex < 7) {
            calendarListState.animateScrollToItem(0)
        } else {
            calendarListState.animateScrollToItem(calendarListState.firstVisibleItemIndex.minus(7))
        }
    }

    suspend fun calendarOnForwardPress(calendarListState: LazyListState) {
        calendarListState.animateScrollToItem(calendarListState.firstVisibleItemIndex.plus(7))
    }

    fun createTask() {
        val taskModel = TaskModel(
            start_time = Timestamp.now(),
            finish_time = Timestamp.now(),
            task_name = _taskNameState.value,
            task_description = _taskDescriptionState.value,
        )
        viewModelScope.launch {
            storageRepository.createTask(taskModel)
        }
    }


}