package com.sajib.media365.ui.views.screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.sajib.media365.R
import com.sajib.media365.ui.views.component.LottieAnimationView
import com.sajib.media365.ui.views.component.MyTopBar
import com.sajib.media365.ui.views.component.RetryAPIFetch
import com.sajib.media365.ui.views.component.StoryDetailsItem
import com.sajib.media365.ui.views.component.contents
import com.sajib.media365.utils.handleScreenState
import kotlinx.serialization.Serializable

@Serializable
data class DetailsScreenRoute(val id: String = "", val headLine: String = "")

@Composable
fun DetailsScreen(navHostController: NavHostController, args: DetailsScreenRoute? = null) {

    val viewModel: StoryDetailsViewModel = hiltViewModel()
    val lifeCycle = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(args?.id) {
        args?.let {
            viewModel.getCateNewsDetails(id = it.id)
        }
    }

    LaunchedEffect(lifeCycle.lifecycle) {
        lifeCycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.cateNewsDetails.collect { response ->
                response?.let { newResponse ->
                    context.handleScreenState(
                        screenState = newResponse,
                        successAction = { data, _ ->
                            viewModel.cateDetailsData = data
                        },

                        )
                }
            }
        }
    }


    Scaffold(
        topBar = {
            MyTopBar(
                onBackClick = {
                    navHostController.popBackStack()
                },
                text = args?.headLine
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(viewModel.cateDetailsData.contents) { content ->
                    StoryDetailsItem(content = content)
                }
            }



            if (viewModel.isLoading) {
                LottieAnimationView(
                    modifier = Modifier.size(50.dp),
                    animationResId = R.raw.loading_cat
                )
            }

            if (viewModel.isFailedLoadAPI) {
                RetryAPIFetch(
                    message = viewModel.errorMessage,
                    onRetry = { viewModel.getCateNewsDetails(id = args?.id ?: "-1") } //fallback -1
                )
            }

        }
    }
}