package com.servicemycar.android.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.servicemycar.android.ui.screens.main.book.DateModel
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.transparent
import com.servicemycar.android.ui.theme.white
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SMCDatePickerDialog(
    onConfirm: (date: DateModel) -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = currentTime.timeInMillis,
    )

    val monthFormat = SimpleDateFormat("MMM", Locale.getDefault())
    val dayOfWeekFormat = SimpleDateFormat("EEEE", Locale.getDefault())

    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""


    DatePickerDialog(
        colors = DatePickerDefaults.colors(containerColor = white),
        shape = RoundedCornerShape(4.dp),
        onDismissRequest = { onDismiss.invoke() },
        confirmButton = {
            OutlinedButton(
                shape = RoundedCornerShape(4.dp),
                border = ButtonDefaults.outlinedButtonBorder(enabled = true),
                colors = ButtonDefaults.buttonColors(containerColor = transparent),
                onClick = {
                    val calendar = Calendar.getInstance()
                    calendar.timeInMillis = datePickerState.selectedDateMillis!!
                    val month = monthFormat.format(calendar.time)
                    onConfirm.invoke(
                        DateModel(
                            date =  calendar.get(Calendar.DATE),
                            month = month,
                            dayOfWeek = dayOfWeekFormat.format(calendar.time),
                            dateTime = calendar.timeInMillis
                        )
                    )
                }
            ) {
                Text(text = "OK", style = MaterialTheme.typography.labelSmall)
            }
        },
        dismissButton = {
            OutlinedButton(
                shape = RoundedCornerShape(4.dp),
                border = ButtonDefaults.outlinedButtonBorder(enabled = true),
                colors = ButtonDefaults.buttonColors(containerColor = transparent),
                onClick = { onDismiss.invoke() }
            ) {
                Text(text = "Cancel", style = MaterialTheme.typography.labelSmall)
            }
        }
    ) {
        DatePicker(
            modifier = Modifier
                .background(white, RoundedCornerShape(4.dp))
                .padding(8.dp),
            colors = DatePickerDefaults.colors(
                containerColor = white,
                selectedDayContentColor = black,
                selectedDayContainerColor = grey,
                selectedYearContentColor = black,
                selectedYearContainerColor = grey,
                weekdayContentColor = black,
                todayDateBorderColor = greyDark,
                dayInSelectionRangeContentColor = white,
                dateTextFieldColors = TextFieldDefaults.colors(
                    selectionColors = TextSelectionColors(
                        handleColor = white,
                        backgroundColor = green
                    ),
                    focusedTextColor = white,
                )
            ),
            state = datePickerState,
            showModeToggle = false,
            title = {
                Text("Please Select the date", style = MaterialTheme.typography.bodyMedium)
            }
        )
    }


//    DateTimePickerDialog(
//        onDismiss = { onDismiss() },
//        onConfirm = { onConfirm(datePickerState) }
//    ) {
//        DatePicker(
//            modifier = Modifier.background(white, RoundedCornerShape(4.dp)),
//            colors = DatePickerDefaults.colors(
//                containerColor = white,
//                selectedDayContentColor = white,
//                weekdayContentColor = black,
//                dayInSelectionRangeContentColor = white,
//                dateTextFieldColors = TextFieldDefaults.colors(
//                    selectionColors = TextSelectionColors(handleColor = white, backgroundColor = green),
//                    focusedTextColor = white,
//                )
//            ),
//            state = datePickerState,
//            showModeToggle = false,
//            title = {
//                Text("Please Select the date", style = MaterialTheme.typography.labelMedium)
//            }
//        )
//    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(
    onConfirm: (TimePickerState) -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false
    )



    DateTimePickerDialog(
        onDismiss = { onDismiss() },
        onConfirm = { onConfirm(timePickerState) }
    ) {
        TimePicker(
            modifier = Modifier.background(white, RoundedCornerShape(4.dp)),
            colors = TimePickerDefaults.colors(
                containerColor = white,
                selectorColor = green,
                clockDialColor = grey,
                clockDialUnselectedContentColor = black,
                periodSelectorUnselectedContainerColor = grey,
                periodSelectorSelectedContainerColor = green.copy(alpha = 0.2f),
                periodSelectorBorderColor = black,
                periodSelectorSelectedContentColor = green,
                periodSelectorUnselectedContentColor = black,
                timeSelectorSelectedContentColor = green,
                timeSelectorUnselectedContentColor = black,
                timeSelectorSelectedContainerColor = green.copy(alpha = 0.2f),
                timeSelectorUnselectedContainerColor = greyDark.copy(alpha = 0.2f),


                ),
            state = timePickerState,
        )
    }
}


@Composable
private fun DateTimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        containerColor = white,
        shape = RoundedCornerShape(4.dp),
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Dismiss", style = MaterialTheme.typography.bodyMedium)
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("OK", style = MaterialTheme.typography.bodyMedium)
            }
        },
        text = { content() }
    )
}