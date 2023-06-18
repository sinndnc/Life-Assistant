package com.android.lifeassistant.core.di.repository

import com.android.lifeassistant.core.data.repository.user.UserRepositoryImpl
import com.android.lifeassistant.core.domain.repostitory.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindStorageRepository(storageRepositoryImpl: UserRepositoryImpl): UserRepository
}