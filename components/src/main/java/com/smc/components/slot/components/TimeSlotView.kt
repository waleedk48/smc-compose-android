package com.smc.components.slot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smc.components.R
import com.smc.components.slot.core.TimeSlotTheme

@Composable
internal fun TimeSlotView(
    slotTime: String,
    onSlotClick: (slot: String) -> Unit,
    theme: TimeSlotTheme,
    isSelected: Boolean,
    fullyBooked: Boolean,
    modifier: Modifier = Modifier
) {

    Box {
        Box(
            modifier = modifier
                .padding(horizontal = 6.dp)
                .background(
                    if (fullyBooked) theme.bookedSlotBackgroundColor else if (isSelected) theme.selectedSlotBackgroundColor else theme.unSelectedSlotBackgroundColor,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 6.dp)
                .clickable(
                    enabled = !fullyBooked
                ) {
                    onSlotClick.invoke(slotTime)
                }

        ) {
            Text(
                slotTime,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = if (fullyBooked) theme.bookedTextColor else if (isSelected) theme.selectedTextColor else theme.unSelectedTextColor,
            )

        }
        if (fullyBooked)
            Icon(
                painter = painterResource(R.drawable.diaognal_line),
                tint = theme.crossLineColor,
                contentDescription = null,

                modifier = Modifier
                    .align(
                        Alignment.Center
                    )
                    .fillMaxWidth()
                    .height(24.dp)
                    .rotate(20f)
            )
    }
}


