package com.sajib.media365.ui.views.screen.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.sajib.media365.ui.views.screen.DetailsScreenRoute
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

private const val TAG = "HomeScreen"
@Composable
fun HomeScreen(navHostController: NavHostController) {

    val viewModel : HomeViewModel = hiltViewModel()
    val post = viewModel.post.collectAsStateWithLifecycle()
    Log.d(TAG, "HomeScreen: ${post.value}")

    Scaffold { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = "Screen A",
                modifier = Modifier.clickable{
                    navHostController.navigate(DetailsScreenRoute("500"))
                }
            )
        }
    }
}