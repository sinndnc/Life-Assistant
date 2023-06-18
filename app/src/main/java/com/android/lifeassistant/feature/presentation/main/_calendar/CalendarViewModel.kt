package com.android.lifeassistant.feature.presentation.main._calendar

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.android.lifeassistant.core.domain.model.util.CalendarTaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor() : ViewModel() {

    private val test = mutableStateListOf(
        CalendarTaskModel(1, 1, 4,"morning run"),
        CalendarTaskModel(1, 9, 16,"launch break"),
        CalendarTaskModel(2, 3, 6,"meet up in Paris"),
        CalendarTaskModel(2, 9, 14,"meet up in Paris"),
        CalendarTaskModel(3, 0, 4,"meet up in Paris"),
        CalendarTaskModel(3, 13, 22,"meet up in Paris"),
        CalendarTaskModel(5, 7, 10,"design review"),
        CalendarTaskModel(7, 14, 20,"workout season on the gym "),
        CalendarTaskModel(8, 2, 4,"launch break"),
    )
    private val _taskList: SnapshotStateList<CalendarTaskModel> = test
    val taskList: SnapshotStateList<CalendarTaskModel> = _taskList


}