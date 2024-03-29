package com.daematech.m_parking.feature_onboading.presentation

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.daematech.m_parking.core.utils.OnboadingPage
import com.daematech.m_parking.navigation.Screens
import com.daematech.m_parking.ui.theme.LightGreen
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnboadingPage.PageOne,
        OnboadingPage.PageTwo,
        OnboadingPage.PageThree
    )
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = 3,
            state = pagerState
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            activeColor = LightGreen,
            inactiveColor = LightGreen.copy(.2f),
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        )
        NextButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            pagerState = pagerState
        ) {
            onBoardingViewModel.saveOnBoardingState(true)
            navController.popBackStack()
            navController.navigate(Screens.HomeScreen.route)
        }
    }
}

@Composable
fun PagerScreen(
    onBoardingPage: OnboadingPage
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 20.dp)

                .clip(
                    RoundedCornerShape(20.dp)
                )
                .background(Color.White.copy(.4f))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = onBoardingPage.title,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = onBoardingPage.description,
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(horizontal = 30.dp, vertical = 30.dp),
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.W700,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NextButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(
            visible = pagerState.currentPage == 2,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp)
                .clip(CircleShape),
            enter = fadeIn() + expandHorizontally(),
            exit = shrinkHorizontally() + fadeOut()
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White.copy(.24f),
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Page1() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnboadingPage.PageOne)
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Page2() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnboadingPage.PageTwo)
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Page3() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnboadingPage.PageThree)
    }
}