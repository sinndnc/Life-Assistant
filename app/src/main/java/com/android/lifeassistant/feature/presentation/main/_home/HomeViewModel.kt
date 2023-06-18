package com.android.lifeassistant.feature.presentation.main._home

import androidx.lifecycle.ViewModel
import com.android.lifeassistant.core.domain.usecase.user.UserUseCase
import com.android.lifeassistant.core.util.calendar.CalendarHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    calendarHelper: CalendarHelper,
    private val userUseCase: UserUseCase
) : ViewModel() {


    val userModel = userUseCase.currentUserModel
    val currentCalendar = calendarHelper.getCurrentDayInMonth
    val daysInMonth = calendarHelper.getDaysInMonth()


}
