package com.sajib.media365.ui.views.screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.sajib.media365.ui.views.component.MyTopBar
import com.sajib.media365.ui.views.component.StoryDetailsItem
import com.sajib.media365.ui.views.component.contents
import kotlinx.serialization.Serializable

@Serializable
data class DetailsScreenRoute(val id: String = "", val headLine : String ="")

@Composable
fun DetailsScreen(navHostController: NavHostController, args: DetailsScreenRoute? = null) {

    val viewModel : StoryDetailsViewModel = hiltViewModel()
    val cateNewsResponse = viewModel.cateNewsDetails.collectAsStateWithLifecycle()

    LaunchedEffect(args?.id) {
        args?.let {
            viewModel.getCateNewsDetails(id = it.id)
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
                cateNewsResponse.value?.let {response ->
                    items(response.contents) {content ->
                        StoryDetailsItem(content = content)
                    }
                }

            }
        }
    }
}