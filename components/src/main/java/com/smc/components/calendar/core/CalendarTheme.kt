package com.smc.components.calendar.core

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CalendarTheme(
    val backgroundColor: Color,
    val headerBackgroundColor: Color,
    val dayBackgroundColor: Color,
    val selectedDayBackgroundColor: Color,
    val dayValueTextColor: Color,
    val selectedDayValueTextColor: Color,
    val headerTextColor: Color,
    val weekDaysTextColor: Color,
    val dayShape: Shape,
    val currentDayBackground: Color,
    val toggleButtonColor: Color,
    val showBorder: Boolean,
    val borderStrokeColor: Color,
    val disabledDayBackgroundColor: Color,
    val disabledDayTextColor: Color,
    val elevation: Dp,
    val crossLineColor: Color,
)

val calendarDefaultTheme: CalendarTheme
    @Composable
    @ReadOnlyComposable
    get() = CalendarTheme(
        backgroundColor = Color.Transparent,
        headerBackgroundColor = Color.Transparent,
        dayBackgroundColor = Color.Transparent,
        selectedDayBackgroundColor = MaterialTheme.colorScheme.primary,
        dayValueTextColor = MaterialTheme.colorScheme.onBackground,
        selectedDayValueTextColor = MaterialTheme.colorScheme.onBackground,
        headerTextColor = MaterialTheme.colorScheme.onBackground,
        weekDaysTextColor = MaterialTheme.colorScheme.onBackground,
        dayShape = CircleShape,
        currentDayBackground = Color.DarkGray,
        toggleButtonColor = Color.Black,
        showBorder = true,
        borderStrokeColor = Color.Black,
        disabledDayBackgroundColor = Color.Gray.copy(alpha = 0.2f),
        disabledDayTextColor = Color.Black.copy(alpha = 0.5f),
        elevation = 1.dp,
        crossLineColor = Color.Red
    )