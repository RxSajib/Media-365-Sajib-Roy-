package com.sajib.media365.ui.views.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.media365.data.model.post.PostResponse
import com.sajib.media365.data.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<PostResponse?>(null)
    val post = mutableStateFlow.asStateFlow()

    init {
        getPost()
    }

    fun getPost(){
        viewModelScope.launch {
            val response = repo.getPost()

            mutableStateFlow.emit(response.data)
        }
    }
}