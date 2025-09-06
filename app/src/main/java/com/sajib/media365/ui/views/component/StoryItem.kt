package com.sajib.media365.ui.views.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sajib.media365.data.model.cat_news_list.Data
import com.sajib.media365.data.model.cat_news_list.Links
import com.sajib.media365.data.model.cat_news_list.TeaserImage
import com.sajib.media365.data.model.cat_news_list.Url
import com.sajib.media365.R

@Composable
fun StoryItem(data: Data) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://example.com/image.jpg",
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.placeholder_image),
            placeholder = painterResource(R.drawable.placeholder_image)
        )
        WidthGap(size = 10.dp)
        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.headline,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "10:00 AM",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.W300
                    )
                )
            }
            HeightGap(size = 5.dp)
            Text(
                text = data.teaserText,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
@Preview
fun MPreview() {
    StoryItem(
        data = stories[0]
    )
}


val stories = listOf(
    Data(
        creationDate = "2020-11-18T00:00:00Z",
        headline = "Story Headline 1",
        id = "1",
        modifiedDate = "2020-11-19T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image1.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 1"
        ),
        teaserText = "This is the teaser text for story one.",
        type = "story",
        url = "https://example.com/story1",
        weblinkUrl = "https://example.com/story1-web"

    ),
    Data(
        creationDate = "2020-11-20T00:00:00Z",
        headline = "Story Headline 2",
        id = "2",
        modifiedDate = "2020-11-21T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image2.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 2"
        ),
        teaserText = "This is the teaser text for story two.",
        type = "story",
        url = "https://example.com/story2",
        weblinkUrl = "https://example.com/story2-web"

    ),
    Data(
        creationDate = "2020-11-22T00:00:00Z",
        headline = "Story Headline 3",
        id = "3",
        modifiedDate = "2020-11-23T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image3.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 3"
        ),
        teaserText = "This is the teaser text for story three.",
        type = "story",
        url = "https://example.com/story3",
        weblinkUrl = "https://example.com/story3-web"

    ),
    Data(
        creationDate = "2020-11-24T00:00:00Z",
        headline = "Story Headline 4",
        id = "4",
        modifiedDate = "2020-11-25T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image4.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 4"
        ),
        teaserText = "This is the teaser text for story four.",
        type = "story",
        url = "https://example.com/story4",
        weblinkUrl = "https://example.com/story4-web"

    ),
    Data(
        creationDate = "2020-11-26T00:00:00Z",
        headline = "Story Headline 5",
        id = "5",
        modifiedDate = "2020-11-27T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image5.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 5"
        ),
        teaserText = "This is the teaser text for story five.",
        type = "story",
        url = "https://example.com/story5",
        weblinkUrl = "https://example.com/story5-web"

    ),
    Data(
        creationDate = "2020-11-28T00:00:00Z",
        headline = "Story Headline 6",
        id = "6",
        modifiedDate = "2020-11-29T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image6.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 6"
        ),
        teaserText = "This is the teaser text for story six.",
        type = "story",
        url = "https://example.com/story6",
        weblinkUrl = "https://example.com/story6-web"

    ),
    Data(
        creationDate = "2020-11-30T00:00:00Z",
        headline = "Story Headline 7",
        id = "7",
        modifiedDate = "2020-12-01T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image7.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 7"
        ),
        teaserText = "This is the teaser text for story seven.",
        type = "story",
        url = "https://example.com/story7",
        weblinkUrl = "https://example.com/story7-web"

    ),
    Data(
        creationDate = "2020-12-02T00:00:00Z",
        headline = "Story Headline 8",
        id = "8",
        modifiedDate = "2020-12-03T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image8.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 8"
        ),
        teaserText = "This is the teaser text for story eight.",
        type = "story",
        url = "https://example.com/story8",
        weblinkUrl = "https://example.com/story8-web"

    ),
    Data(
        creationDate = "2020-12-04T00:00:00Z",
        headline = "Story Headline 9",
        id = "9",
        modifiedDate = "2020-12-05T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image9.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 9"
        ),
        teaserText = "This is the teaser text for story nine.",
        type = "story",
        url = "https://example.com/story9",
        weblinkUrl = "https://example.com/story9-web"

    ),
    Data(
        creationDate = "2020-12-06T00:00:00Z",
        headline = "Story Headline 10",
        id = "10",
        modifiedDate = "2020-12-07T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(
                url = Url(
                    href = "https://example.com/image10.jpg",
                    templated = false,
                    type = "image/jpeg"
                )
            ),
            accessibilityText = "Image description 10"
        ),
        teaserText = "This is the teaser text for story ten.",
        type = "story",
        url = "https://example.com/story10",
        weblinkUrl = "https://example.com/story10-web"
    )

)
