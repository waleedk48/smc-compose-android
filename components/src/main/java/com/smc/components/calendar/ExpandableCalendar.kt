package com.smc.components.calendar

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.smc.components.calendar.components.InlineCalendar
import com.smc.components.calendar.components.MonthText
import com.smc.components.calendar.components.MonthViewCalendar
import com.smc.components.calendar.components.ToggleExpandCalendarButton
import com.smc.components.calendar.core.CalendarIntent
import com.smc.components.calendar.core.CalendarTheme
import com.smc.components.calendar.core.Period
import com.smc.components.calendar.core.calendarDefaultTheme
import com.smc.components.calendar.utils.getWeekStartDate

import java.time.LocalDate
import java.time.YearMonth

@Composable
fun ExpandableCalendar(
    onDayClick: (LocalDate) -> Unit,
    theme: CalendarTheme = calendarDefaultTheme
) {
    val viewModel: CalendarViewModel = viewModel()
    val loadedDates = viewModel.visibleDates.collectAsState()
    val selectedDate = viewModel.selectedDate.collectAsState()
    val calendarExpanded = viewModel.calendarExpanded.collectAsState()
    val currentMonth = viewModel.currentMonth.collectAsState()
    ExpandableCalendar(
        loadedDates = loadedDates.value,
        selectedDate = selectedDate.value,
        currentMonth = currentMonth.value,
        onIntent = viewModel::onIntent,
        calendarExpanded = calendarExpanded.value,
        theme = theme,
        onDayClick = onDayClick
    )
}

@SuppressLint("NewApi")
@Composable
private fun ExpandableCalendar(
    loadedDates: Array<List<LocalDate>>,
    selectedDate: LocalDate,
    currentMonth: YearMonth,
    onIntent: (CalendarIntent) -> Unit,
    calendarExpanded: Boolean,
    theme: CalendarTheme,
    onDayClick: (LocalDate) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors().copy(containerColor = theme.backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = theme.elevation),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            if (theme.showBorder) 1.dp else 0.dp,
            color = theme.borderStrokeColor,
        ),
        modifier = Modifier.animateContentSize()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
                    .background(theme.headerBackgroundColor)
            ) {
                Spacer(Modifier.width(12.dp))
                MonthText(selectedMonth = currentMonth, theme = theme)
                Spacer(Modifier.weight(1f))
                ToggleExpandCalendarButton(
                    isExpanded = calendarExpanded,
                    expand = { onIntent(CalendarIntent.ExpandCalendar) },
                    collapse = { onIntent(CalendarIntent.CollapseCalendar) },
                    color = theme.toggleButtonColor
                )
            }
            if (calendarExpanded) {
                MonthViewCalendar(
                    loadedDates,
                    selectedDate,
                    theme = theme,
                    currentMonth = currentMonth,
                    loadDatesForMonth = { yearMonth ->
                        onIntent(
                            CalendarIntent.LoadNextDates(
                                yearMonth.atDay(
                                    1
                                ), period = Period.MONTH
                            )
                        )
                    },
                    onDayClick = {
                        onIntent(CalendarIntent.SelectDate(it))
                        onDayClick(it)
                    }
                )
            } else {
                InlineCalendar(
                    loadedDates,
                    selectedDate,
                    theme = theme,
                    loadNextWeek = { nextWeekDate ->
                        onIntent(
                            CalendarIntent.LoadNextDates(
                                nextWeekDate
                            )
                        )
                    },
                    loadPrevWeek = { endWeekDate ->
                        onIntent(
                            CalendarIntent.LoadNextDates(
                                endWeekDate.minusDays(1).getWeekStartDate()
                            )
                        )
                    },
                    onDayClick = {
                        onIntent(CalendarIntent.SelectDate(it))
                        onDayClick(it)
                    }
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}