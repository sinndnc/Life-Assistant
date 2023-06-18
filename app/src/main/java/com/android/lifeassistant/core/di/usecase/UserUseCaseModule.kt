package com.android.lifeassistant.core.di.usecase

import com.android.lifeassistant.core.domain.usecase.user.UserUseCase
import com.android.lifeassistant.core.domain.usecase.user.UserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserUseCaseModule(){

    @Binds
    @Singleton
    abstract fun bindUserUseCaseModule( userUseCaseImpl: UserUseCaseImpl) : UserUseCase
}
