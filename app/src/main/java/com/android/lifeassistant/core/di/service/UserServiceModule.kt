package com.android.lifeassistant.core.di.service

import com.android.lifeassistant.core.data.remote.user.UserRemoteServiceImpl
import com.android.lifeassistant.core.domain.remote.user.UserRemoteService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserServiceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteStorageService(remoteStorageServiceImpl: UserRemoteServiceImpl): UserRemoteService
}