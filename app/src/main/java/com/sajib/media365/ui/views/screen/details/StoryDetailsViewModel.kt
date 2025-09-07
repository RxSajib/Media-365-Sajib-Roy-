package com.sajib.media365.ui.views.screen.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.media365.data.model.cat_news_list.CatNewsListResponse
import com.sajib.media365.data.model.cate_news_details.CateNewsDetails
import com.sajib.media365.data.repo.Repo
import com.sajib.media365.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "StoryDetailsViewModel"

@HiltViewModel
class StoryDetailsViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    private val storyDetailsMutableStateFlow = MutableStateFlow<ScreenState<CateNewsDetails>?>(null)
    val cateNewsDetails = storyDetailsMutableStateFlow.asStateFlow()
    var isLoading by mutableStateOf(false)
    var cateDetailsData by mutableStateOf(CateNewsDetails())

    var errorMessage by mutableStateOf("")
    var isFailedLoadAPI by mutableStateOf(false)

    fun getCateNewsDetails(id: String) {

        viewModelScope.launch {
            isLoading = true
            isFailedLoadAPI = false
            val response = repo.getStoryDetails(id = id)
            isLoading = false

            if(response.isSuccess){
                storyDetailsMutableStateFlow.emit(ScreenState.Success(data = response.data))
                errorMessage = ""
                isFailedLoadAPI = false
            }else {
                storyDetailsMutableStateFlow.emit(ScreenState.Error(message = response.error?.message?: "Something went wrong"))
                errorMessage = response.error?.message?: "Something went wrong"
                isFailedLoadAPI = true
            }
        }
    }
}