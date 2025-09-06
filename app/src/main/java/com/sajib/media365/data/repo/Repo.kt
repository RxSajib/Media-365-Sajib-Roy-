package com.sajib.media365.data.repo

import com.sajib.media365.data.model.GenericResponse
import com.sajib.media365.data.model.post.PostResponse

interface Repo {

    suspend fun getPost() : GenericResponse<PostResponse>
}