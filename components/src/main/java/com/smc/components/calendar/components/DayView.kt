package com.smc.components.calendar.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.smc.components.R
import com.smc.components.calendar.core.CalendarTheme
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle

/**
 * View that represent one day in the calendar
 * @param date date that view should represent
 * @param weekDayLabel flag that indicates if name of week day should be visible above day value
 * @param modifier view modifier
 */
@SuppressLint("NewApi")
@Composable
fun DayView(
    date: LocalDate,
    onDayClick: (LocalDate) -> Unit,
    theme: CalendarTheme,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    weekDayLabel: Boolean = true
) {




    val isCurrentDay = date == LocalDate.now()
    val dayValueModifier =
        if (isCurrentDay && !isSelected) modifier.background(
            theme.currentDayBackground,
            shape = theme.dayShape
        )
        else if (isSelected) modifier.background(
            theme.selectedDayBackgroundColor,
            shape = theme.dayShape
        )
        else if (date < LocalDate.now()) modifier.background(
            theme.disabledDayBackgroundColor,
            shape = theme.dayShape
        ) else modifier.background(theme.dayBackgroundColor, shape = theme.dayShape)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .heightIn(max = if (weekDayLabel) 36.dp + 30.dp else 36.dp)
            .widthIn(max = 36.dp)
            .testTag("day_view_column")
    ) {
        if (weekDayLabel) {
            Text(
                DayOfWeek.entries[date.dayOfWeek.value - 1].getDisplayName(
                    TextStyle.SHORT,
                    LocalContext.current.resources.configuration.locales[0]
                ),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = theme.weekDaysTextColor
            )
            Box(modifier = Modifier.height(8.dp))
        }
        if (!weekDayLabel) {
            Box(modifier = Modifier.height(4.dp))
        }


            Box(
                dayValueModifier
                    .padding(6.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .clickable(enabled = date >= LocalDate.now()) { onDayClick(date) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    date.dayOfMonth.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                   // textDecoration = if (date < LocalDate.now()) TextDecoration.LineThrough else null,

                    color = if (isSelected || isCurrentDay) theme.selectedDayValueTextColor else if (date < LocalDate.now()) theme.disabledDayTextColor else theme.dayValueTextColor
                )

                if (date < LocalDate.now())
                    Icon(
                        painter = painterResource(R.drawable.diaognal_line),
                        tint = theme.crossLineColor,
                        contentDescription = null,

                        modifier = Modifier
                            .align(
                                Alignment.Center
                            )
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                            .height(24.dp)
                            .rotate(20f)
                    )
        }
    }
}