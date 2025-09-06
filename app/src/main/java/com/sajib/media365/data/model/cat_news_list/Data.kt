package com.sajib.media365.data.model.cat_news_list


import androidx.annotation.Keep


data class Data(
    val creationDate: String,
    val headline: String,
    val id: String,
    val modifiedDate: String,
    val teaserImage: TeaserImage,
    val teaserText: String,
    val type: String,
    val url: String,
    val weblinkUrl: String
)