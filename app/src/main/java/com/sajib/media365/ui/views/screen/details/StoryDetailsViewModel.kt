package com.sajib.media365.ui.views.screen.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.media365.data.model.cate_news_details.CateNewsDetails
import com.sajib.media365.data.repo.Repo
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

    private val storyDetailsMutableStateFlow = MutableStateFlow<CateNewsDetails?>(null)
    val cateNewsDetails = storyDetailsMutableStateFlow.asStateFlow()

    fun getCateNewsDetails(id : String){
        Log.d(TAG, "getCateNewsDetails: call")
        viewModelScope.launch {
            repo.getStoryDetails(id = id)
        }
    }
}