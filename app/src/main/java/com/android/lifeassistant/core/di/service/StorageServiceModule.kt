package com.android.lifeassistant.core.di.service

import com.android.lifeassistant.core.data.remote.storage.StorageRemoteServiceImpl
import com.android.lifeassistant.core.domain.remote.storage.StorageRemoteService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
abstract class StorageServiceModule {

    @Binds
    @Singleton
    abstract fun bindLoginService(storageRemoteServiceImpl: StorageRemoteServiceImpl): StorageRemoteService
}