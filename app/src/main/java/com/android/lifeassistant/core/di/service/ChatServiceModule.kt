package com.android.lifeassistant.core.di.service

import com.android.lifeassistant.core.data.remote.chat.ChatRemoteServiceImpl
import com.android.lifeassistant.core.domain.remote.chat.ChatRemoteService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ChatServiceModule {

    @Binds
    @Singleton
    abstract fun bindChatRemoteService(chatRemoteServiceImpl: ChatRemoteServiceImpl): ChatRemoteService
}