package com.sajib.media365.data.repo

import com.google.gson.Gson
import com.sajib.media365.data.model.ErrorResponse
import com.sajib.media365.data.model.GenericResponse
import com.sajib.media365.data.model.post.PostResponse
import com.sajib.media365.data.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class RepoImpl @Inject constructor(
    private val myApi: MyApi
) : Repo {
    override suspend fun getPost(): GenericResponse<PostResponse> {
       return executeSafely {
            myApi.getPost()
       }
    }
}


suspend fun <T : Any> executeSafely(
    block: suspend () -> Response<GenericResponse<T>>
): GenericResponse<T> = withContext(Dispatchers.IO) {
    try {
        block().toGenericResponse()
    } catch (ce: CancellationException) {
        throw ce
    } catch (e: UnknownHostException) {
        GenericResponse(error = ErrorResponse(message = "No Internet Connection"))
    } catch (e: SocketTimeoutException) {
        GenericResponse(error = ErrorResponse(message = "Request timed out"))
    } catch (e: Exception) {
        GenericResponse(error = ErrorResponse(message = e.message ?: "Something went wrong"))
    }
}

private fun <T : Any> Response<GenericResponse<T>>.toGenericResponse(): GenericResponse<T> {
    if (isSuccessful) {
        return body() ?: GenericResponse(error = ErrorResponse(message = "Empty response body"))
    }

    val fallback = GenericResponse<T>(
        error = ErrorResponse(code = code(), message = message())
    )

    val raw = try {
        errorBody()?.string()
    } catch (_: Exception) {
        null
    } ?: return fallback

    // Parse only the error object; avoid GenericResponse<T> erasure issues
    return runCatching {
        val parsedError = Gson().fromJson(raw, ErrorResponse::class.java)
        GenericResponse<T>(error = parsedError ?: ErrorResponse(code = code(), message = message()))
    }.getOrElse { fallback }
}

