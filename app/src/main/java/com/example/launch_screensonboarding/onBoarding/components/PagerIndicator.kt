package com.example.launch_screensonboarding.onBoarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(
    color: Color,
    widthState: State<Dp>
) {
    Box(modifier = Modifier
        .padding(2.dp)
        .clip(CircleShape)
        .width(widthState.value)
        .background(color)
        .size(10.dp)
    )
}