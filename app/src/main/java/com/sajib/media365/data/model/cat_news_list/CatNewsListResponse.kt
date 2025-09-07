package com.sajib.media365.data.model.cat_news_list


data class CatNewsListResponse(
    val `data`: List<Data>,
    val title: String
)

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

data class Links(
    val url: Url
)

data class TeaserImage(
    val _links: Links,
    val accessibilityText: String
)

data class Url(
    val href: String,
    val templated: Boolean,
    val type: String
)