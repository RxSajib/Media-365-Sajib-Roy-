package com.sajib.media365.data.network

import com.sajib.media365.data.model.response.GenericResponse
import com.sajib.media365.data.model.post.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("posts")
    suspend fun getPost(): Response<GenericResponse<PostResponse>>
}