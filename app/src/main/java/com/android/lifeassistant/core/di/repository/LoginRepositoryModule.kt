package com.android.lifeassistant.core.di.repository

import com.android.lifeassistant.core.data.repository.auth.LoginRepositoryImpl
import com.android.lifeassistant.core.domain.repostitory.auth.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository
}