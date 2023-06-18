package com.android.lifeassistant.core.di.repository

import com.android.lifeassistant.core.data.repository.chat.ChatRepositoryImpl
import com.android.lifeassistant.core.domain.repostitory.chat.ChatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ChatRepositoryModule {

    @Binds
    abstract fun bindChatRepository(chatRepositoryImpl: ChatRepositoryImpl): ChatRepository
}