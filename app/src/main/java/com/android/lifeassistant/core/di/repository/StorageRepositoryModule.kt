package com.android.lifeassistant.core.di.repository

import com.android.lifeassistant.core.data.repository.storage.StorageRepositoryImpl
import com.android.lifeassistant.core.domain.repostitory.storage.StorageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageRepositoryModule {

    @Binds
    abstract fun bindChatRepository(storageRepositoryImpl: StorageRepositoryImpl): StorageRepository
}