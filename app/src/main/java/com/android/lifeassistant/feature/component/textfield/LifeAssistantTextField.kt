package com.android.lifeassistant.feature.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.android.lifeassistant.feature.component.text.LifeAssistantText

@Composable
fun LifeAssistantTextField(
    modifier: Modifier = Modifier,
    value: MutableState<String>,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next
) {

    val themeColor = MaterialTheme.colors
    val themeTypography = MaterialTheme.typography
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = value.value,
        onValueChange = { value.value = it },
        textStyle = themeTypography.body1,
        label = { LifeAssistantText(text = label, style = MaterialTheme.typography.body2) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            },
            onDone = {
                focusManager.clearFocus()
            }
        ),
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = themeColor.surface.copy(0.8f),
            textColor = themeColor.onSurface,
        )
    )
}