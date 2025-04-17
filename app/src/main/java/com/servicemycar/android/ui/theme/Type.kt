package com.servicemycar.android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.servicemycar.android.R
import ir.kaaveh.sdpcompose.ssp


private val dmSansFontFamily = FontFamily(
    Font(R.font.dmsans_regular, FontWeight.Normal),
    Font(R.font.dmsans_medium, FontWeight.SemiBold),
    Font(R.font.dmsans_bold, FontWeight.Bold),
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Normal,
        color = greyDark,
        fontSize = 11.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.2.sp
    ),
    bodyMedium =  TextStyle(
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Normal,
        color = black,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.35.sp
    ),

    bodyLarge =  TextStyle(
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Normal,
        color = black,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Normal,
        color = black,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Medium,
        color = black,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

    labelMedium = TextStyle(
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        color = black,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp,
        fontStyle = FontStyle.Normal
    ),

    labelLarge = TextStyle(
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Bold,
        color = black,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp,
        fontStyle = FontStyle.Normal
    )



)