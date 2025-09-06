package com.sajib.media365.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sajib.media365.R


val poppinsRegular = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal)
)

val poppinsBold = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold)
)


@Composable
fun adjustedFontSize(baseSize: Int): Float {
    val configuration = LocalConfiguration.current
    val densityDpi = configuration.densityDpi
    return if (densityDpi > 320) baseSize + 2f else baseSize.toFloat()
}

@Composable
fun getMaterialTypography(): Typography {
    return Typography(

        bodyLarge = TextStyle(
            fontFamily = poppinsRegular,
            fontWeight = FontWeight.Bold,
            fontSize = adjustedFontSize(16).sp,
            lineHeight = adjustedFontSize(24).sp,
            //letterSpacing = 0.5.sp,
            color = text_body
        ),

        bodyMedium = TextStyle(
            fontFamily = poppinsRegular,
            fontWeight = FontWeight.Normal,
            fontSize = adjustedFontSize(14).sp,
            lineHeight = adjustedFontSize(20).sp,
            //letterSpacing = 0.15.sp,
            color = text_body
        ),

        bodySmall = TextStyle(
            fontFamily = poppinsRegular,
            fontWeight = FontWeight.Normal,
            fontSize = adjustedFontSize(12).sp,
            lineHeight = adjustedFontSize(16).sp,
            //letterSpacing = 0.10.sp,
            color = text_body
        ),

        titleMedium = TextStyle(
            fontFamily = poppinsRegular,
            fontWeight = FontWeight.Bold,
            fontSize = adjustedFontSize(18).sp,
            lineHeight = adjustedFontSize(24).sp,
            //letterSpacing = 0.15.sp,
            color = text_body
        ),

        titleLarge = TextStyle(
            fontFamily = poppinsRegular,
            fontWeight = FontWeight.Bold,
            fontSize = adjustedFontSize(24).sp,
            lineHeight = adjustedFontSize(30).sp,
            //letterSpacing = 0.15.sp,
            color = text_body
        ),


        )
}