package com.example.launch_screensonboarding.ui.theme.onBoarding

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.launch_screensonboarding.ui.theme.onBoarding.components.MyButton
import com.example.launch_screensonboarding.ui.theme.onBoarding.components.MyImage
import com.example.launch_screensonboarding.ui.theme.onBoarding.components.PagerIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GuideScreen() {
    val items = ItemsData.items
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()
    HorizontalPager(
        pageCount = items.size, state = pagerState
    ) { page ->
        Box(modifier = Modifier.fillMaxSize()) {
            Box {
                MyImage(
                    painter = painterResource(items[page].image)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 4.dp, end = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 4.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = "Skip",
                                textAlign = TextAlign.End,
                                color = items[page].mainColor,
                                fontSize = 20.sp
                            )
                        }
                    }
                    Text(
                        text = items[page].mainTitle,
                        textAlign = TextAlign.Center,
                        color = items[page].mainColor,
                        fontWeight = FontWeight.Normal,
                        fontSize = 30.sp
                    )
                }
            }
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()
            ) {
                Column {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(10.dp),
                    ) {
                        Text(
                            text = items[page].title,
                            color = items[page].mainColor,
                            fontWeight = FontWeight.Light,
                            fontSize = 30.sp
                        )
                        Text(
                            text = items[page].description,
                            color = items[page].mainColor,
                            fontWeight = FontWeight.Light,
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(modifier = Modifier.padding(10.dp).fillMaxWidth() ,horizontalArrangement = Arrangement.Center) {
                            repeat(items.size){
                                    selectedPage ->
                                val color = if (pagerState.currentPage == selectedPage) Color.White else Color.LightGray
                                val widthValue = animateDpAsState(targetValue = if(pagerState.currentPage == selectedPage) 40.dp else 10.dp )
                                PagerIndicator(color, widthValue)
                            }
                        }
                        if (pagerState.currentPage <= 1) {
                            MyButton(
                                onClick = {
                                   coroutineScope.launch {
                                       pagerState.animateScrollToPage(
                                           pagerState.currentPage + 1
                                       )
                                   }
                                }, text = "Next"
                            )
                        } else {
                            MyButton(
                                onClick = {}, text = "Get Started"
                            )
                        }
                    }
                }
            }
        }
    }
}

