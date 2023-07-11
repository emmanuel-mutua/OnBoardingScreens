package com.example.launch_screensonboarding.ui.theme.onBoarding

import androidx.compose.ui.graphics.Color
import com.example.launch_screensonboarding.R

data class KitchenData(
    val image: Int,
    val mainTitle: String = "Kitchen Stories",
    val title : String,
    val description: String,
    val mainColor: Color = Color.White
)

object ItemsData{
     val items= ArrayList<KitchenData>()
    init {
        items.add(
            KitchenData(
                image = R.drawable.kitchen1,
                title = "Get Inspired",
                description = "Discover delicious recipes and stunning food stories",
            )
        )
        items.add(
            KitchenData(
                image = R.drawable.kitchen2,
                title = "Sharpen your skills",
                description = "With our cooking videos and top tips",
            )
        )
        items.add(
            KitchenData(
                image = R.drawable.kitchen3,
                title = "Share your recipes",
                description = "With our international community",
            )
        )
    }
}
