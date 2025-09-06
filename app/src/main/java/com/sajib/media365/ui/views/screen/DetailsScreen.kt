package com.sajib.media365.ui.views.screen

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
data class DetailsScreenRoute(val id : String = "")

@Composable
fun DetailsScreen(navHostController: NavHostController, args: DetailsScreenRoute? = null) {
    Scaffold { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = "id is ${args?.id?: ""}"
            )
        }
    }
}