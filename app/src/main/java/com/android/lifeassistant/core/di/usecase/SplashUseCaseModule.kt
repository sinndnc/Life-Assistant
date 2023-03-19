package com.android.lifeassistant.core.di.usecase

import com.android.lifeassistant.core.domain.usecase.splash.SplashUseCase
import com.android.lifeassistant.core.domain.usecase.splash.SplashUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SplashUseCaseModule(){

    @Binds
    @Singleton
    abstract fun bindIsUserLoggedUseCase( checkIsUserLoggedImpl: SplashUseCaseImpl) : SplashUseCase
}
