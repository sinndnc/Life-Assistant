package com.android.lifeassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
import com.android.lifeassistant.core.domain.repostitory.user.UserRepository
import com.android.lifeassistant.core.util.notification.NotificationHelper
import com.android.lifeassistant.core.util.theme.ThemeSetting
import com.android.lifeassistant.core.util.theme.ThemeState
import com.android.lifeassistant.feature.component.theme.LifeAssistantTheme
import com.android.lifeassistant.feature.navigation.main.LifeAssistantNavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var themeSetting: ThemeSetting

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var notificationHelper: NotificationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeSettings()
        initializeContent()
    }

    private fun initializeContent() {
        setContent {
            val theme = themeSetting.themeState.collectAsState()
            LifeAssistantTheme(ThemeState.Dark) {
                LifeAssistantNavigationGraph()
            }
        }
    }

    private fun initializeSettings() {
        userRepository.registerUserToken()
        notificationHelper.createTaskNotificationChannel()
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}

