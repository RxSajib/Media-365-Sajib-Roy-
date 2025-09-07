package com.sajib.media365.ui.views.screen.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.media365.data.model.cat_news_list.CatNewsListResponse
import com.sajib.media365.data.model.post.PostResponse
import com.sajib.media365.data.repo.Repo
import com.sajib.media365.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "HomeViewModel"
@SuppressLint("MutableCollectionMutableState")
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<ScreenState<PostResponse>?>(null)
    val post = mutableStateFlow.asStateFlow()


    private val mutableStateFlowStoryList = MutableStateFlow<ScreenState<CatNewsListResponse>?>(null)
    val cateNewsList = mutableStateFlowStoryList.asStateFlow()
    var isLoading by mutableStateOf(false)
    var cateNewsData by mutableStateOf(CatNewsListResponse())

    var errorMessage by mutableStateOf("")
    var isFailedLoadAPI by mutableStateOf(false)
    var postData by mutableStateOf(PostResponse())

    init {
        getStoryList()
    }

    fun getPost(){
        viewModelScope.launch {
            isLoading = true
            isFailedLoadAPI = false
            val response = repo.getPost()
            isLoading = false


            if(response.isSuccess){
                mutableStateFlow.emit(ScreenState.Success(data = response.data))
                errorMessage = ""
                isFailedLoadAPI = false
            }else {
                mutableStateFlow.emit(ScreenState.Error(message = response.error?.message?: "Something went wrong"))
                errorMessage = response.error?.message?: "Something went wrong"
                isFailedLoadAPI = true
            }

        }
    }

    fun getStoryList(){
        viewModelScope.launch {
            isLoading = true
            isFailedLoadAPI = false
            val response = repo.getNewsList()
            isLoading = false


            if(response.isSuccess){
                mutableStateFlowStoryList.emit(ScreenState.Success(data = response.data))
                isFailedLoadAPI = false
                errorMessage = ""

            }else {
                mutableStateFlowStoryList.emit(ScreenState.Error(message = response.error?.message?: "Something went wrong"))
                isFailedLoadAPI = true
                errorMessage = response.error?.message?: "Something went wrong"
                Log.d(TAG, "getPost: data ${response.error?.message}")
            }

        }
    }
}