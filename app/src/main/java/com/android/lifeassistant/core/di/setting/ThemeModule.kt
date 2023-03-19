package com.android.lifeassistant.core.di.setting

import com.android.lifeassistant.core.util.theme.ThemeSetting
import com.android.lifeassistant.core.util.theme.ThemeSettingImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ThemeModule {

    @Binds
    @Singleton
    abstract fun bindThemeSetting(themeSettingImpl: ThemeSettingImpl): ThemeSetting
}