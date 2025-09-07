package com.sajib.media365.data.model.cate_news_details


import androidx.annotation.Keep

data class CateNewsDetails(
    val contents: List<Content> = emptyList(),
    val creationDate: String? = null,
    val headline: String?= null,
    val heroImage: HeroImage? = null,
    val id: String?= null,
    val modifiedDate: String ?= null
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