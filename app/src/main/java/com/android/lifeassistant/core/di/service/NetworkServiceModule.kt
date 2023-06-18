package com.android.lifeassistant.core.di.service

import com.android.lifeassistant.core.data.remote.network.NetworkServiceImpl
import com.android.lifeassistant.core.domain.remote.network.NetworkService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkServiceModule {

    @Binds
    @Singleton
    abstract fun bindLoginService(networkServiceImpl: NetworkServiceImpl): NetworkService

}