package com.smc.components.calendar

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smc.components.calendar.core.CalendarIntent
import com.smc.components.calendar.core.DateTimeConstants
import com.smc.components.calendar.core.Period
import com.smc.components.calendar.core.RelativePosition
import com.smc.components.calendar.utils.getNextDates
import com.smc.components.calendar.utils.getRemainingDatesInMonth
import com.smc.components.calendar.utils.getRemainingDatesInWeek
import com.smc.components.calendar.utils.getWeekStartDate
import com.smc.components.calendar.utils.yearMonth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.YearMonth

class CalendarViewModel : ViewModel() {

    @SuppressLint("NewApi")
    private val _visibleDates =
        MutableStateFlow(
            calculateCollapsedCalendarDays(
                startDate = LocalDate.now().getWeekStartDate().minusWeeks(1)
            )
        )
    val visibleDates: StateFlow<Array<List<LocalDate>>> = _visibleDates

    @SuppressLint("NewApi")
    private val _selectedDate = MutableStateFlow(LocalDate.now().plusDays(
        1))
    val selectedDate: StateFlow<LocalDate> = _selectedDate

    val currentMonth: StateFlow<YearMonth>
        @SuppressLint("NewApi")
        get() = calendarExpanded.zip(visibleDates) { isExpanded, dates ->
            if (isExpanded) {
                dates[RelativePosition.CURRENT.ordinal][dates[RelativePosition.CURRENT.ordinal].size / 2].yearMonth()
            } else {
                if (dates[RelativePosition.CURRENT.ordinal].count { it.month == dates[RelativePosition.CURRENT.ordinal].first().month } > RelativePosition.entries.size
                ) {
                    dates[RelativePosition.CURRENT.ordinal].first()
                        .yearMonth()
                } else {
                    dates[RelativePosition.CURRENT.ordinal].last()
                        .yearMonth()
                }
            }
        }.stateIn(viewModelScope, SharingStarted.Eagerly, LocalDate.now().yearMonth())


    private val _calendarExpanded = MutableStateFlow(false)
    val calendarExpanded: StateFlow<Boolean> = _calendarExpanded


    @SuppressLint("NewApi")
    fun onIntent(intent: CalendarIntent) {
        when (intent) {
            CalendarIntent.ExpandCalendar -> {
                calculateCalendarDates(
                    startDate = currentMonth.value
                        .minusMonths(1)
                        .atDay(1),
                    period = Period.MONTH
                )
                _calendarExpanded.value = true
            }

            CalendarIntent.CollapseCalendar -> {
                calculateCalendarDates(
                    startDate = calculateCollapsedCalendarVisibleStartDay()
                        .getWeekStartDate()
                        .minusWeeks(1),
                    period = Period.WEEK
                )
                _calendarExpanded.value = false
            }

            is CalendarIntent.LoadNextDates -> {
                calculateCalendarDates(intent.startDate, intent.period)
            }

            is CalendarIntent.SelectDate -> {
                viewModelScope.launch {
                    _selectedDate.emit(intent.date)
                }
            }
        }
    }

    private fun calculateCalendarDates(
        startDate: LocalDate,
        period: Period = Period.WEEK
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            _visibleDates.emit(
                when (period) {
                    Period.WEEK -> calculateCollapsedCalendarDays(startDate)
                    Period.MONTH -> calculateExpandedCalendarDays(startDate)
                }
            )
        }
    }

    @SuppressLint("NewApi")
    private fun calculateCollapsedCalendarVisibleStartDay(): LocalDate {
        val halfOfMonth =
            visibleDates.value[RelativePosition.CURRENT.ordinal][visibleDates.value[RelativePosition.CURRENT.ordinal].size / 2]
        val visibleMonth = YearMonth.of(halfOfMonth.year, halfOfMonth.month)
        return if (selectedDate.value.month == visibleMonth.month && selectedDate.value.year == visibleMonth.year)
            selectedDate.value
        else visibleMonth.atDay(1)
    }

    private fun calculateCollapsedCalendarDays(startDate: LocalDate): Array<List<LocalDate>> {
        val dates =
            startDate.getNextDates(RelativePosition.entries.size * DateTimeConstants.DAYS_IN_WEEK)
        return Array(RelativePosition.entries.size) {
            dates.slice(it * DateTimeConstants.DAYS_IN_WEEK until (it + 1) * DateTimeConstants.DAYS_IN_WEEK)
        }
    }

    @SuppressLint("NewApi")
    private fun calculateExpandedCalendarDays(startDate: LocalDate): Array<List<LocalDate>> {
        val array = Array(RelativePosition.entries.size) { monthIndex ->
            val monthFirstDate = startDate.plusMonths(monthIndex.toLong())
            val monthLastDate = monthFirstDate.plusMonths(1).minusDays(1)
            val weekBeginningDate = monthFirstDate.getWeekStartDate()
            if (weekBeginningDate != monthFirstDate) {
                weekBeginningDate.getRemainingDatesInMonth()
            } else {
                listOf()
            } +
                    monthFirstDate.getNextDates(monthFirstDate.month.length(monthFirstDate.isLeapYear)) +
                    monthLastDate.getRemainingDatesInWeek()
        }
        return array
    }
}