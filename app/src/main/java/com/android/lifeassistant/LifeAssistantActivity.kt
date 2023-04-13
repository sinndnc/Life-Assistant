package com.android.lifeassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeContent()
    }

    private fun initializeContent() {
        initializeSettings()
        setContent {
            val theme = themeSetting.themeState.collectAsState()
            LifeAssistantTheme(ThemeState.Dark) {
                LifeAssistantNavigationGraph()
            }
        }
    }

    private fun initializeSettings() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}

