package com.sajib.media365.ui.views.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Scaffold { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = "Screen A",
                modifier = Modifier.clickable{
                    navHostController.navigate(DetailsScreenRoute("500"))
                }
            )
        }
    }
}