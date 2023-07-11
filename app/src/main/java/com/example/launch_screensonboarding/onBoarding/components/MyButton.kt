package com.example.launch_screensonboarding.onBoarding.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyButton(
    onClick: () -> Unit,
    text : String
) {
    Button(onClick,
    modifier = Modifier.fillMaxWidth()) {
        Text(text = text)
    }
}