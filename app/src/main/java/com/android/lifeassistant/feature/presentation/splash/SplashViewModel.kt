package com.android.lifeassistant.feature.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.android.lifeassistant.core.domain.usecase.splash.SplashUseCase
import com.android.lifeassistant.feature.navigation.content.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val splashUseCase : SplashUseCase
) : ViewModel() {

    fun isAuthenticated(navController : NavController){
        viewModelScope.launch {
            navController.popBackStack()
            if (splashUseCase.execute()) {
                navController.navigate(Content.MAIN_GRAPH)
            } else {
                navController.navigate(Content.AUTH_GRAPH)
            }
        }
    }
}
