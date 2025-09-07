package com.sajib.media365.data.model.cate_news_details


import androidx.annotation.Keep

data class CateNewsDetails(
    val contents: List<Content>,
    val creationDate: String,
    val headline: String,
    val heroImage: HeroImage,
    val id: String,
    val modifiedDate: String
)

data class Content(
    val accessibilityText: String,
    val text: String,
    val type: String,
    val url: String
)

data class HeroImage(
    val accessibilityText: String,
    val imageUrl: String
)