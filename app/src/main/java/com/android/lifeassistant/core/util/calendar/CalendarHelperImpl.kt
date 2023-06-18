package com.android.lifeassistant.core.util.calendar

import com.android.lifeassistant.core.domain.model.util.CalendarModel
import com.android.lifeassistant.core.domain.model.util.TimeModel
import java.util.*
import javax.inject.Inject

class CalendarHelperImpl @Inject constructor() : CalendarHelper() {

    override val calendar: Calendar = Calendar.getInstance()

    override val getCurrentDayInMonth = calendar.get(Calendar.DAY_OF_MONTH)

    override fun getDaysInMonth(): MutableList<CalendarModel> {
        var i = 1
        val daysInMonth = mutableListOf<CalendarModel>()
        val getLastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        while (i <= getLastDayOfMonth) {
            calendar.set(Calendar.YEAR, calendar[Calendar.YEAR])
            calendar.set(Calendar.MONTH, calendar[Calendar.MONTH])
            calendar.set(Calendar.DAY_OF_MONTH, i)
            val day = calendar.get(Calendar.DAY_OF_WEEK)
            val month = calendar.get(Calendar.MONTH)
            daysInMonth.add(CalendarModel(i, daysOfWeek[day - 1], daysOfMonth[month]))
            i++
        }
        return daysInMonth
    }

    override fun getTimeOfSpecifiedDate(date: Date): TimeModel {
        calendar.time = date
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return TimeModel(minute, hour, day)
    }

}