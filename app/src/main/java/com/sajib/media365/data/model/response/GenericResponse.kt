package com.sajib.media365.data.model.response

import com.google.gson.annotations.SerializedName

data class GenericResponse<T : Any?>(
    val data: T? = null,
    val error: ErrorResponse? = null,
    val isSuccess : Boolean
)

data class ErrorResponse(
    val code: Int = 400, val message: String = "Something went wrong", val path: String = "",

    @SerializedName("times  tamp") val timeStamp: String = ""
)
