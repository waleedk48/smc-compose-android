package com.smc.components.slot

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smc.components.slot.components.TimeSlotView
import com.smc.components.slot.core.TimeSlotTheme
import com.smc.components.slot.core.timeSlotDefaultTheme
import java.time.format.TextStyle
import kotlin.random.Random

@Composable
fun TimeSlotsSMC(
    modifier: Modifier = Modifier,
    onTimeSlotClick: (slot: String) -> Unit,
    slots: Map<String, Boolean>,
    theme: TimeSlotTheme = timeSlotDefaultTheme,
) {

    var selectedSlot by remember { mutableStateOf(slots.entries.first { it.value }) }
    Box(
        modifier = modifier

            .border(
                if (theme.showBorder) 1.dp else 0.dp,
                color = theme.borderStrokeColor,
                shape = RoundedCornerShape(8.dp)
            )
            .background(theme.backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.Start
        ){
          if( theme.showLabel) {
              Text(
                  "Time Slot",
                  fontWeight = FontWeight.Bold,
                  fontSize = 16.sp,
                  textAlign = TextAlign.Start,
                  color = theme.labelTextColor,
                  modifier = modifier
              )
              Box(modifier = Modifier.height(8.dp))
          }
            LazyRow(modifier = modifier) {
                slots.forEach {
                    item {
                        TimeSlotView(
                            slotTime = it.key,
                            isSelected = it.key == selectedSlot.key,
                            fullyBooked = it.value,
                            theme = theme,
                            onSlotClick = { selected ->
                                selectedSlot = slots.entries.first { it.key == selected }
                                onTimeSlotClick.invoke(selected)
                            }
                        )
                    }
                }
            }
        }
    }
}


val dummySlots: Map<String, Boolean> = (0..11).associate { index ->
    val hour = index + 8
    val amPm = if (hour < 12) "AM" else "PM"
    val adjustedHour = if (hour > 12) hour - 12 else hour
    val presentHour = if(adjustedHour -1 == 0) 12 else adjustedHour-1
    val timeSlot = "$presentHour - $adjustedHour $amPm"
    timeSlot to Random.nextBoolean()
}