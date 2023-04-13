package com.android.lifeassistant.feature.presentation.auth.onboard

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.android.lifeassistant.feature.navigation.content.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor() : ViewModel() {

    fun navigateToLoginContent(navController: NavController){
        navController.navigate(Content.Login.route)
    }

    fun navigateToSignUpContent(navController: NavController){
        navController.navigate(Content.SignUp.route)
    }

}