package com.android.lifeassistant.core.util.calendar

import com.android.lifeassistant.core.domain.model.util.CalendarModel
import java.util.Calendar


abstract class CalendarHelper {

    abstract val calendar : Calendar

    abstract val getCurrentDayInMonth: Int

    abstract fun getDaysInMonth() : MutableList<CalendarModel>

    companion object{
        val daysOfWeek = listOf("Sun","Mon","Tue","Wed","Thu","Fri","Sat")
        val daysOfMonth = listOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
    }

}