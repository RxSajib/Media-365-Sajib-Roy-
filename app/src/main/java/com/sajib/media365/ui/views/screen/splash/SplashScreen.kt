package com.sajib.media365.ui.views.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sajib.media365.ui.views.component.LottieAnimationView
import kotlinx.serialization.Serializable
import com.sajib.media365.R
import com.sajib.media365.ui.views.screen.home.HomeScreenRoute
import kotlinx.coroutines.delay

@Serializable
data object SplashScreenRoute

@Composable
fun SplashScreen(navHostController: NavHostController) {
    Scaffold { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), contentAlignment = Alignment.Center){
            LottieAnimationView(
                modifier = Modifier.size(100.dp),
                animationResId = R.raw.loading_cat
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(4000L)
        navHostController.navigate(HomeScreenRoute){
            popUpTo(0){
                inclusive = false
            }
        }
    }
}