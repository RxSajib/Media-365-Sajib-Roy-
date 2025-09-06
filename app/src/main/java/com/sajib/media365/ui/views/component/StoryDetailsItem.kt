package com.sajib.media365.ui.views.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sajib.media365.R
import com.sajib.media365.data.model.cate_news_details.Content

@Composable
fun StoryDetailsItem(content: Content) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)) {
            AsyncImage(
                model = content.url, // set image url
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                error = painterResource(R.drawable.placeholder_image),
                placeholder = painterResource(R.drawable.placeholder_image)
            )
        }

        HeightGap(size = 10.dp)
        Text(
            text = content.text,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium
        )

        HeightGap(15.dp)
    }
}

@Preview
@Composable
fun StoryDetailsPreview(modifier: Modifier = Modifier) {
    StoryDetailsItem(content = contents[0])
}


val contents = listOf(
    Content(
        accessibilityText = "Description 1",
        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
        type = "story",
        url = "https://example.com/content1"
    ),
    Content(
        accessibilityText = "Description 2",
        text = "It is a long established fact that a reader will be distracted by the readable content " +
                "of a page when looking at its layout. The point of using Lorem Ipsum is that it has a " +
                "more-or-less normal distribution of letters.",
        type = "story",
        url = "https://example.com/content2"
    ),
    Content(
        accessibilityText = "Description 3",
        text = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece " +
                "of classical Latin literature from 45 BC, making it over 2000 years old.",
        type = "story",
        url = "https://example.com/content3"
    ),
    Content(
        accessibilityText = "Description 4",
        text = "There are many variations of passages of Lorem Ipsum available, but the majority have " +
                "suffered alteration in some form, by injected humour or randomized words.",
        type = "story",
        url = "https://example.com/content4"
    ),
    Content(
        accessibilityText = "Description 5",
        text = "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker " +
                "including versions of Lorem Ipsum.",
        type = "story",
        url = "https://example.com/content5"
    ),
    Content(
        accessibilityText = "Description 6",
        text = "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. " +
                "Sections 1.10.32 and 1.10.33 from Cicero's work are also reproduced.",
        type = "story",
        url = "https://example.com/content6"
    ),
    Content(
        accessibilityText = "Description 7",
        text = "Lorem Ipsum has survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged.",
        type = "story",
        url = "https://example.com/content7"
    ),
    Content(
        accessibilityText = "Description 8",
        text = "Various versions of Lorem Ipsum have evolved over the years, sometimes by accident, " +
                "sometimes on purpose (injected humour and the like).",
        type = "story",
        url = "https://example.com/content8"
    ),
    Content(
        accessibilityText = "Description 9",
        text = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, " +
                "and a search for 'lorem ipsum' will uncover many web sites still in their infancy.",
        type = "story",
        url = "https://example.com/content9"
    ),
    Content(
        accessibilityText = "Description 10",
        text = "It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, " +
                "to generate Lorem Ipsum which looks reasonable.",
        type = "story",
        url = "https://example.com/content10"
    )
)
