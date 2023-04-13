package com.android.lifeassistant.core.di.helper


import com.android.lifeassistant.core.util.calendar.CalendarHelper
import com.android.lifeassistant.core.util.calendar.CalendarHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CalendarModule {

    @Binds
    @Singleton
    abstract fun bindCalendarHelper(calendarHelperImpl: CalendarHelperImpl): CalendarHelper
}