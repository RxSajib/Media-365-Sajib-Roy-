package com.sajib.media365.ui.views.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sajib.media365.data.model.cat_news_list.Links
import com.sajib.media365.data.model.cat_news_list.TeaserImage
import com.sajib.media365.data.model.cat_news_list.Url
import com.sajib.media365.R
import com.sajib.media365.data.model.cat_news_list.Data
import com.sajib.media365.utils.TimeDateConverter.formatRelativeTime

@Composable
fun StoryItem(data: Data, onClick: (Data) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                onClick.invoke(data)
            }
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(10.dp),
    ) {
        AsyncImage(
            model = data.url, //load image url
            contentDescription = null,
            modifier = Modifier.size(50.dp),
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
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = formatRelativeTime(dateString = data.creationDate),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.W300,
                        color = colorResource(R.color.textBody).copy(0.2f)
                    )
                )
            }
            HeightGap(size = 5.dp)
            Text(
                text = data.teaserText,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = colorResource(R.color.textBody).copy(0.6f)
                ),
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
        data = stories[0],
        onClick = {}
    )
}


val stories = listOf(
    Data(
        creationDate = "2020-11-18T00:00:00Z",
        headline = "Story Headline 1",
        id = "1",
        modifiedDate = "2020-11-19T00:00:00Z",
        teaserImage = TeaserImage(
            _links = Links(url = Url("https://example.com/image1.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 1"
        ),
        teaserText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
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
            _links = Links(url = Url("https://example.com/image2.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 2"
        ),
        teaserText = "Lorem Ipsum is simply dummy text used as a placeholder for design and publishing. " +
                "It provides a neutral block of text that allows focus to remain on typography, " +
                "layout, and overall presentation rather than on the meaning of words. " +
                "Its nonsensical structure makes it universally adaptable.",
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
            _links = Links(url = Url("https://example.com/image3.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 3"
        ),
        teaserText = "Contrary to popular belief, Lorem Ipsum is not random text. " +
                "Its roots are in a piece of classical Latin literature from 45 BC, making it over 2000 years old. " +
                "Richard McClintock, a Latin professor, discovered its origin by identifying obscure Latin words " +
                "used in the passages and tracing them back to Cicero.",
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
            _links = Links(url = Url("https://example.com/image4.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 4"
        ),
        teaserText = "There are many variations of passages of Lorem Ipsum available, " +
                "but the majority have suffered alteration in some form, by injected humour, " +
                "or randomized words which don't look even slightly believable. " +
                "If you are going to use a passage of Lorem Ipsum, be sure there isn't anything embarrassing hidden.",
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
            _links = Links(url = Url("https://example.com/image5.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 5"
        ),
        teaserText = "Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of Cicero's 'de Finibus Bonorum et Malorum'. " +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. " +
                "Sections 1.10.32 and 1.10.33 are also reproduced in their exact original form, " +
                "accompanied by English versions from 1914 translations.",
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
            _links = Links(url = Url("https://example.com/image6.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 6"
        ),
        teaserText = "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, " +
                "as opposed to using 'Content here, content here', making it look like readable English. " +
                "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text.",
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
            _links = Links(url = Url("https://example.com/image7.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 7"
        ),
        teaserText = "It is a long established fact that a reader will be distracted by the readable content of a page " +
                "when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal " +
                "distribution of letters, making it resemble English while avoiding meaningful distractions.",
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
            _links = Links(url = Url("https://example.com/image8.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 8"
        ),
        teaserText = "Various versions of Lorem Ipsum have evolved over the years, sometimes by accident, " +
                "sometimes on purpose, injected with humour and the like. " +
                "Designers often substitute Lorem Ipsum into drafts to help stakeholders focus on layout, " +
                "color, and typography instead of scrutinizing words.",
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
            _links = Links(url = Url("https://example.com/image9.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 9"
        ),
        teaserText = "Lorem Ipsum passages not only provide filler text but also approximate the frequency " +
                "and variation of English letters. This creates a natural flow for evaluating " +
                "visual balance, kerning, leading, and spacing in design without meaningful distractions.",
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
            _links = Links(url = Url("https://example.com/image10.jpg", false, "image/jpeg")),
            accessibilityText = "Image description 10"
        ),
        teaserText = "When designing content-heavy layouts, Lorem Ipsum provides a neutral way " +
                "to simulate paragraphs, headings, and text blocks. It allows designers " +
                "to test readability, contrast, and hierarchy, ensuring usability before real content is available.",
        type = "story",
        url = "https://example.com/story10",
        weblinkUrl = "https://example.com/story10-web"
    )
)

