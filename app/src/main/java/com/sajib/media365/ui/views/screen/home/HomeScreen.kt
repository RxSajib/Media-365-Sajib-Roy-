package com.sajib.media365.ui.views.screen.home

import android.text.Layout
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.sajib.media365.ui.views.component.MyTopBar
import com.sajib.media365.ui.views.screen.details.DetailsScreenRoute
import kotlinx.serialization.Serializable
import com.sajib.media365.R
import com.sajib.media365.ui.views.component.LottieAnimationView
import com.sajib.media365.ui.views.component.RetryAPIFetch
import com.sajib.media365.ui.views.component.StoryItem
import com.sajib.media365.ui.views.component.stories
import com.sajib.media365.utils.handleScreenState

@Serializable
object HomeScreenRoute

private const val TAG = "HomeScreen"

@Composable
fun HomeScreen(navHostController: NavHostController) {

    val viewModel: HomeViewModel = hiltViewModel()
    val context = LocalContext.current
    val lifeCycle = LocalLifecycleOwner.current

    LaunchedEffect(lifeCycle.lifecycle) {
        lifeCycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.cateNewsList.collect { response ->
               response?.let { newResponse ->
                   context.handleScreenState(
                       screenState = newResponse,
                       successAction = { data, _ ->
                           viewModel.cateNewsData = data
                       },

                   )
               }
            }
        }
    }

    Scaffold(
        topBar = {
            MyTopBar(
                text = context.getString(R.string.home),
                onBackClick = {},
                showBackButton = false
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {


            LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items( viewModel.cateNewsData.data) { data ->
                        StoryItem(data = data, onClick = { clickData ->
                            navHostController.navigate(
                                DetailsScreenRoute(
                                    id = clickData.id,
                                    headLine = clickData.headline
                                )
                            )
                        })
                    }

            }

            if (viewModel.isLoading) {
                LottieAnimationView(
                    modifier = Modifier.size(50.dp),
                    animationResId = R.raw.loading_cat
                )
            }

            if(viewModel.isFailedLoadAPI){
                RetryAPIFetch(
                    message = viewModel.errorMessage,
                    onRetry = {viewModel.getStoryList()}
                )
            }

        }
    }
}