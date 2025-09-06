package com.sajib.media365.data.network

import com.sajib.media365.data.model.cat_news_list.CatNewsListResponse
import com.sajib.media365.data.model.cate_news_details.CateNewsDetails
import com.sajib.media365.data.model.response.GenericResponse
import com.sajib.media365.data.model.post.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {


    @GET("posts")
    suspend fun getPost(): Response<PostResponse>


    @GET("news-list")
    suspend fun getNewsList(): Response<CatNewsListResponse>

    @GET("story/{id}")
    suspend fun getStoryDetails(@Path("id") id: String): Response<CateNewsDetails>
}