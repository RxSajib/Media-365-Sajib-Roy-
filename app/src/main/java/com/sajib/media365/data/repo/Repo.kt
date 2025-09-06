package com.sajib.media365.data.repo

import com.sajib.media365.data.model.cat_news_list.CatNewsListResponse
import com.sajib.media365.data.model.cate_news_details.CateNewsDetails
import com.sajib.media365.data.model.response.GenericResponse
import com.sajib.media365.data.model.post.PostResponse
import okhttp3.Response

interface Repo {

    suspend fun getPost() : GenericResponse<PostResponse>

    suspend fun getNewsList() : GenericResponse<CatNewsListResponse>

    suspend fun getStoryDetails(id : String) : GenericResponse<CateNewsDetails>
}