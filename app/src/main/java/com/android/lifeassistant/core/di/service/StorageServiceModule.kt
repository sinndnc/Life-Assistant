package com.android.lifeassistant.core.di.service

import com.android.lifeassistant.core.data.remote.storage.RemoteStorageServiceImpl
import com.android.lifeassistant.core.domain.remote.storage.RemoteStorageService
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
    abstract fun bindRemoteStorageService(remoteStorageServiceImpl: RemoteStorageServiceImpl): RemoteStorageService
}