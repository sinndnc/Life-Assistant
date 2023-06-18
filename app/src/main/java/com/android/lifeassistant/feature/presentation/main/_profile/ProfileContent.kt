package com.android.lifeassistant.feature.presentation.main._profile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.lifeassistant.feature.component.text.LifeAssistantText

@Composable
fun ProfileContent(viewModel: ProfileViewModel, navController: NavController) {

    val userModel = viewModel.userModel.collectAsState()
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { imageUri ->
        viewModel.storageRepository.uploadProfileImageFromGallery(imageUri!!)
    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .weight(0.55f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                userModel.value.image?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.CenterStart,
                        contentDescription = "profile image",
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .size(150.dp),
                    )
                }
                IconButton(onClick = { launcher.launch("image/*") }) {
                    Icon(Icons.Rounded.Edit, contentDescription = "profile edit icon")
                }
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                LifeAssistantText(text = "Anton Jr.", style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
                LifeAssistantText(text = "Creative director at @ui8.net")
                LifeAssistantText(text = "a designer that keens simplicity and usability")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Blue)
                        .clickable { }
                        .padding(10.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    LifeAssistantText(
                        text = "Book class  |  s1,300,00",
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .weight(0.4f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.DarkGray)
                        .clickable { }
                        .padding(10.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    LifeAssistantText(
                        text = "Follow",
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                repeat(3) {
                    Column {
                        LifeAssistantText(text = "Students", color = Color.Gray)
                        LifeAssistantText(text = "35,789", style = MaterialTheme.typography.h6, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .weight(0.45f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .weight(0.125f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.DarkGray)
                    .padding(1.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .weight(0.35f)
                            .fillMaxHeight()
                            .padding(1.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center,
                    ) {
                        LifeAssistantText(text = "Courses")
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(0.875f)
                    .fillMaxWidth(),
            ) {

            }
        }
    }

}