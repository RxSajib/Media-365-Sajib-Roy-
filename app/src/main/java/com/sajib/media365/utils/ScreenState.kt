package com.sajib.media365.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

sealed class ScreenState<T>(
    val data: T? = null, val message: String? = null
) {
    class Success<T>(data: T?, message: String? = null) : ScreenState<T>(data, message = message)
    class Error<T>(message: String, data: T? = null) :
        ScreenState<T>(message = message, data = data)
    class Unknown<T> : ScreenState<T>()

}

inline fun <reified T> Context.handleScreenState(
    screenState: ScreenState<T>, errorAction: (T?, String?) -> Unit = { res, msg ->
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }, successAction: (T, String?) -> Unit = { _, msg ->

        msg?.let {
            Log.d("ScreenState", "handleScreenState: $msg")
        }
    }
) {
    when (screenState) {
        is ScreenState.Error -> errorAction(screenState.data, screenState.message)
        is ScreenState.Success -> successAction(screenState.data!!, screenState.message)
        is ScreenState.Unknown -> null
    }
}