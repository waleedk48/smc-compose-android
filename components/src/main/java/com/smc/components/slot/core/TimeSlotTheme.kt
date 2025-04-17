package com.smc.components.slot.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

data class TimeSlotTheme(
    val backgroundColor: Color,
    val selectedSlotBackgroundColor: Color,
    val unSelectedSlotBackgroundColor: Color,
    val selectedTextColor: Color,
    val unSelectedTextColor: Color,
    val bookedTextColor: Color,
    val bookedSlotBackgroundColor: Color,
    val borderStrokeColor: Color,
    val showBorder: Boolean,
    val crossLineColor:Color,
    val showLabel:Boolean,
    val labelTextColor:Color,
)

val timeSlotDefaultTheme: TimeSlotTheme
    @Composable
    @ReadOnlyComposable
    get() = TimeSlotTheme(
        backgroundColor = Color.Transparent,
        selectedSlotBackgroundColor = Color.Black,
        unSelectedSlotBackgroundColor = Color.Transparent,
        selectedTextColor = Color.White,
        unSelectedTextColor = Color.Black,
        bookedTextColor = Color.Red,
        bookedSlotBackgroundColor = Color.Red.copy(alpha = 0.2f),
        borderStrokeColor = Color.Black,
        showBorder = true,
        crossLineColor = Color.Red,
        showLabel = true,
        labelTextColor = Color.Black
    )