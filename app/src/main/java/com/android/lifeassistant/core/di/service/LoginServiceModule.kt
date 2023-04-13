package com.android.lifeassistant.core.di.service

import com.android.lifeassistant.core.data.remote.auth.LoginServiceImpl
import com.android.lifeassistant.core.domain.remote.auth.LoginService
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
    abstract fun bindLoginService(loginServiceImpl: LoginServiceImpl): LoginService
}