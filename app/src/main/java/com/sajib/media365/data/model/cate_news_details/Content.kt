package com.sajib.media365.data.model.cate_news_details


import androidx.annotation.Keep

@Keep
data class Content(
    val accessibilityText: String,
    val text: String,
    val type: String,
    val url: String
)