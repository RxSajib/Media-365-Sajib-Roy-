package com.sajib.media365.utils

import android.os.Build
import android.text.format.DateUtils
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object TimeDateConverter {


    fun formatRelativeTime(dateString: String): String {
        val sdf = SimpleDateFormat("yy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")

        val date: Date = sdf.parse(dateString) ?: return ""
        val now = System.currentTimeMillis()

        val diff = now - date.time

        return when {
            diff < DateUtils.MINUTE_IN_MILLIS -> "just now"
            diff < DateUtils.HOUR_IN_MILLIS -> "${diff / DateUtils.MINUTE_IN_MILLIS} min ago"
            diff < DateUtils.DAY_IN_MILLIS -> "${diff / DateUtils.HOUR_IN_MILLIS} hours ago"
            diff < 7 * DateUtils.DAY_IN_MILLIS -> "${diff / DateUtils.DAY_IN_MILLIS} days ago"
            else -> SimpleDateFormat("yy-MM-dd HH:mm", Locale.getDefault()).format(date)
        }
    }

}