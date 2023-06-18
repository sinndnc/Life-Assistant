package com.android.lifeassistant.core.di.helper

import com.android.lifeassistant.core.util.notification.NotificationHelper
import com.android.lifeassistant.core.util.notification.NotificationHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NotificationHelperModule {

    @Binds
    @Singleton
    abstract fun bindCalendarHelper(notificationHelperImpl: NotificationHelperImpl): NotificationHelper
}