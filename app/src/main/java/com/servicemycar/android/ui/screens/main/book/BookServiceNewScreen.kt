package com.servicemycar.android.ui.screens.main.book

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.models.ServiceModel
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.theme.yellow
import com.smc.components.calendar.ExpandableCalendar
import com.smc.components.calendar.core.CalendarTheme
import com.smc.components.calendar.core.calendarDefaultTheme
import com.smc.components.slot.TimeSlotsSMC
import com.smc.components.slot.core.timeSlotDefaultTheme
import com.smc.components.slot.dummySlots

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookServiceNewScreen(
    navController: NavController,
    serviceModel: ServiceModel
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Major Service",
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = black,
                            fontSize = 18.sp,
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }) {
                        Icon(
                            modifier = Modifier
                                .size(26.dp, 30.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(color = black)
                                .padding(horizontal = 6.dp, vertical = 6.dp),
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = null,
                            tint = white
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
            )
        },
        containerColor = backgroundColor,
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(12.dp)
        ) {
            ExpandableCalendar(
                onDayClick = {
                }, theme = calendarDefaultTheme.copy(
                    selectedDayBackgroundColor = black,
                    dayBackgroundColor = grey,
                    selectedDayValueTextColor = white,
                    weekDaysTextColor = greyDark,
                    currentDayBackground = green.copy(alpha = 0.6f),
                    toggleButtonColor = greyDark,
                    borderStrokeColor = grey,
                    dayValueTextColor = black,
                    dayShape = CircleShape,
                    headerTextColor = black,
                    showBorder = true,
                    elevation = 0.dp,
                    disabledDayBackgroundColor =  grey,
                    crossLineColor = red,
                )
            )
            15.dp.toheight()
            TimeSlotsSMC(
                onTimeSlotClick = { s -> }, slots = dummySlots, theme = timeSlotDefaultTheme.copy(
                    selectedTextColor = white,
                    unSelectedTextColor = black,
                    selectedSlotBackgroundColor = black,
                    unSelectedSlotBackgroundColor = grey,
                    borderStrokeColor = grey,
                    bookedSlotBackgroundColor = grey,
                    bookedTextColor = greyDark.copy(alpha = 0.7f),
                    crossLineColor = red,
                    showLabel = false
                )
            )
        }
    }
}

@Composable
@Preview
private fun BookServiceNewScreenPreview() {
    BookServiceNewScreen(
        navController = NavController(LocalContext.current),
        serviceModel = ServiceModel(id = "", name = "Major Service")
    )
}