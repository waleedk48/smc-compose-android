package com.servicemycar.android.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.transparent
import com.servicemycar.android.utils.secondsToMM_SS
import kotlinx.coroutines.delay


const val WAITING_TIME = 1L// in seconds


@Composable
fun CountdownTimer(
    duration: Long = 30L,
    waitTime: Long = WAITING_TIME,
    onTick: (remainingTime: Long) -> Unit,
    onFinish: () -> Unit,
) {
    var timeLeft by remember { mutableLongStateOf(duration) }
    var isRunning by remember { mutableStateOf(true) }

    LaunchedEffect(timeLeft,isRunning) {
        if (isRunning && timeLeft > 0) {
            delay(waitTime *1000)
            timeLeft -= 1 // Decrement the time left
            onTick(timeLeft) // Call the onTick callback
        } else if (timeLeft == 0L) {
            isRunning = false // Stop the timer
            onFinish() // Call the onFinish callback when done
        }
    }

    if (timeLeft > 0) Text(
        "Resend OTP in " + timeLeft.secondsToMM_SS(),
        style = MaterialTheme.typography.bodyLarge.copy(color = black)
    ) else {
        OutlinedButton(
            onClick = {
                timeLeft = duration
                isRunning = true
            },
            border = ButtonDefaults.outlinedButtonBorder(true).copy(width = 1.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors()
                .copy(containerColor = transparent),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Resend OTP",
                style = MaterialTheme.typography.labelMedium.copy(color = black)
            )
        }
    }
}