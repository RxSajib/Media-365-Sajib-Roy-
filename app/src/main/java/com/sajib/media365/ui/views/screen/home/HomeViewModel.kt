package com.sajib.media365.ui.views.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.media365.data.model.cat_news_list.CatNewsListResponse
import com.sajib.media365.data.model.post.PostResponse
import com.sajib.media365.data.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "HomeViewModel"
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<PostResponse?>(null)
    val post = mutableStateFlow.asStateFlow()


    private val mutableStateFlowStoryList = MutableStateFlow<CatNewsListResponse?>(null)
    val cateNewsList = mutableStateFlowStoryList.asStateFlow()
    var isLoading by mutableStateOf(false)

    init {
        getPost()
        getStoryList()
    }

    fun getPost(){
        viewModelScope.launch {
            isLoading = true
            val response = repo.getPost()
            isLoading = false
            mutableStateFlow.emit(response.data)
        }
    }

    fun getStoryList(){
        viewModelScope.launch {
            val response = repo.getNewsList()
            Log.d(TAG, "getPost: data ${response.error?.message}")

            mutableStateFlowStoryList.emit(response.data)
        }
    }
}