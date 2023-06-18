package com.android.lifeassistant.core.di.helper

import com.android.lifeassistant.core.util.notification.component.NotificationComponent
import com.android.lifeassistant.core.util.notification.component.NotificationComponentImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NotificationComponentModule {

    @Binds
    @Singleton
    abstract fun bindNotificationHelper(notificationComponentImpl: NotificationComponentImpl): NotificationComponent
}