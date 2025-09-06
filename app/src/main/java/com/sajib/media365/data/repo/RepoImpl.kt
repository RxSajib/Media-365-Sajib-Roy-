package com.sajib.media365.data.repo

import android.util.Log
import com.google.gson.Gson
import com.sajib.media365.data.model.cat_news_list.CatNewsListResponse
import com.sajib.media365.data.model.cate_news_details.CateNewsDetails
import com.sajib.media365.data.model.response.ErrorResponse
import com.sajib.media365.data.model.response.GenericResponse
import com.sajib.media365.data.model.post.PostResponse
import com.sajib.media365.data.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException
import kotlin.math.log

class RepoImpl @Inject constructor(
    private val myApi: MyApi
) : Repo {
    override suspend fun getPost(): GenericResponse<PostResponse> {
        return executeSafely {
            myApi.getPost()
        }
    }

    override suspend fun getNewsList(): GenericResponse<CatNewsListResponse> {
        return executeSafely {
            myApi.getNewsList()
        }
    }

    override suspend fun getStoryDetails(id: String): GenericResponse<CateNewsDetails> {
        return executeSafely {
            myApi.getStoryDetails(id = id)
        }
    }


}


suspend fun <T : Any> executeSafely(
    block: suspend () -> Response<T>
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

private fun <T : Any> Response<T>.toGenericResponse(): GenericResponse<T> {
    if (isSuccessful) {
        val body = body()
        return if (body != null) GenericResponse(data = body)
        else GenericResponse(error = ErrorResponse(message = "Empty response body"))
    }

    val fallback = GenericResponse<T>(error = ErrorResponse(code = code(), message = message()))
    val raw = try { errorBody()?.string() } catch (_: Exception) { null } ?: return fallback

    return runCatching {
        val parsed = Gson().fromJson(raw, ErrorResponse::class.java)
        GenericResponse<T>(error = parsed ?: ErrorResponse(code = code(), message = message()))
    }.getOrElse { fallback }
}

