package com.sajib.media365.data.model.cat_news_list


import androidx.annotation.Keep


data class CatNewsListResponse(
    val `data`: List<Data>,
    val title: String
)