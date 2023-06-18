package com.android.lifeassistant.core.di.service

import com.android.lifeassistant.core.data.remote.auth.LoginRemoteServiceImpl
import com.android.lifeassistant.core.domain.remote.auth.LoginRemoteService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginServiceModule {

    @Binds
    @Singleton
    abstract fun bindLoginService(loginServiceImpl: LoginRemoteServiceImpl): LoginRemoteService
}