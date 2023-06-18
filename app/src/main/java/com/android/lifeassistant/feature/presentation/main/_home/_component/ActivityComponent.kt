package com.android.lifeassistant.feature.presentation.main._home._component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.theme.Blue500
import com.android.lifeassistant.feature.presentation.main._home.HomeViewModel

@Composable
fun ColumnScope.ActivityComponent(homeViewModel: HomeViewModel) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val activityState = rememberLazyListState(homeViewModel.currentCalendar - 1)

    LazyRow(
        modifier = Modifier
            .weight(0.8f)
            .fillMaxSize(),
        state = activityState,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        itemsIndexed(homeViewModel.daysInMonth) { index, item ->

            val isSelected = homeViewModel.currentCalendar - 1 == index
            val backgroundColor = if (isSelected) Blue500 else Color.White
            val textColor = if (isSelected) Color.White else Color.DarkGray

            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Column(
                modifier = Modifier
                    .height(screenHeight.dp * 0.100f)
                    .width(screenWidth.dp * 0.175f)
                    .clip(MaterialTheme.shapes.medium)
                    .background(backgroundColor),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = item.dayName, color = textColor)
                Text(
                    text = item.dayNumber.toString(),
                    color = textColor,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}