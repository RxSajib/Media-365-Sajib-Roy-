package com.sajib.media365.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sajib.media365.ui.views.screen.details.DetailsScreen
import com.sajib.media365.ui.views.screen.details.DetailsScreenRoute
import com.sajib.media365.ui.views.screen.home.HomeScreen
import com.sajib.media365.ui.views.screen.home.HomeScreenRoute
import com.sajib.media365.ui.views.screen.splash.SplashScreen
import com.sajib.media365.ui.views.screen.splash.SplashScreenRoute

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SplashScreenRoute) {
        composable<SplashScreenRoute> { SplashScreen(navHostController = navController) }
        composable<HomeScreenRoute> { HomeScreen(navHostController = navController) }

        composable<DetailsScreenRoute> {
            val args = it.toRoute<DetailsScreenRoute>()
            DetailsScreen(navHostController = navController, args)
        }
    }
}