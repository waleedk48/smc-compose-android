package com.smc.components.calendar.components


import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.smc.components.calendar.core.CalendarTheme
import java.time.YearMonth
import java.time.format.TextStyle

@SuppressLint("NewApi")
@Composable
fun MonthText(selectedMonth: YearMonth, theme: CalendarTheme, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        selectedMonth.month.getDisplayName(
            TextStyle.FULL_STANDALONE,
            context.resources.configuration.locales[0]
        ) + " " + selectedMonth.year,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        textAlign = TextAlign.Start,
        color = theme.headerTextColor,
        modifier = modifier
    )
}