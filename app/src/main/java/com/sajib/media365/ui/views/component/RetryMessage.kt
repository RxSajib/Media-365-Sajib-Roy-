package com.sajib.media365.ui.views.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sajib.media365.R

@Composable
fun RetryAPIFetch(message: String, onRetry: () -> Unit) {

    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = message, style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.W300
            )
        )
        HeightGap(size = 10.dp)
        Button(
            onClick = { onRetry.invoke() },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.textBody))
        ) {
            Text(
                text = context.getString(R.string.retry),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = colorResource(R.color.white)
                )
            )
        }
    }
}

@Composable
@Preview
fun RetryPreview(modifier: Modifier = Modifier) {
    RetryAPIFetch(message = "Filed to connect please try again", onRetry = {})
}