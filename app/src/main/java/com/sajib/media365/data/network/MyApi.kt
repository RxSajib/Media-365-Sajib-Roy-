package com.sajib.media365.data.network

import com.sajib.media365.data.model.GenericResponse
import com.sajib.media365.data.model.post.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {
    @GET("posts")
    suspend fun getPost(): Response<GenericResponse<PostResponse>>
}