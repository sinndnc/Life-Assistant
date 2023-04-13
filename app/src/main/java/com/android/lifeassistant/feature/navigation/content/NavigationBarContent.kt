package com.android.lifeassistant.feature.navigation.content

import LifeAssistant.R

sealed class NavigationBarContent(val route: String, val selectedIcon: Int, val unSelectedIcon: Int) {
    object Home : NavigationBarContent("Home", R.drawable.home_fill, R.drawable.home)
    object Message : NavigationBarContent("Message", R.drawable.message_fill, R.drawable.message)
    object Calender : NavigationBarContent("Calender", R.drawable.calendar_fill, R.drawable.calendar)
    object Profile : NavigationBarContent("Profile", R.drawable.profile_fill, R.drawable.profile)

    companion object {
        val navigationItemList = listOf(Home, Message, Calender, Profile)
    }
}