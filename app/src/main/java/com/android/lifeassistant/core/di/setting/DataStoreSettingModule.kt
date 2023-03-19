package com.android.lifeassistant.core.di.setting

import com.android.lifeassistant.core.data.local.dataStore.DataStoreSettingImpl
import com.android.lifeassistant.core.domain.local.dataStore.DataStoreSetting
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreSettingModule {

    @Binds
    @Singleton
    abstract fun bindDataStoreSetting(dataStoreSettingImpl: DataStoreSettingImpl): DataStoreSetting
}