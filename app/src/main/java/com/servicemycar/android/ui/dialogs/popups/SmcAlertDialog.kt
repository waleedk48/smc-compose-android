package com.servicemycar.android.ui.dialogs.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.theme.white
import kotlinx.coroutines.launch


@Composable
fun SmcAlertView(
    title: String = "Alert",
    message: String = "something will be here to alert",
    positiveButtonText: String = "Ok",
    negativeButtonText: String = "Cancel",
    onPositiveButtonClick: () -> Unit = {},
    onNegativeButtonClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(fraction = 0.90f)
            .wrapContentWidth(),
        color = white,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, style = MaterialTheme.typography.labelMedium.copy(fontSize = 18.sp))
            12.dp.toheight()
            Text(message, style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp))
            16.dp.toheight()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ElevatedButton(
                    onClick = {
                        onPositiveButtonClick.invoke()
                    },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .heightIn(max = 40.dp)
                ) {
                    Text(
                        text = positiveButtonText,
                        style = MaterialTheme.typography.labelSmall.copy(color = white)
                    )
                }
                10.dp.toWidth(modifier = Modifier.weight(0.1f))
                ElevatedButton(
                    onClick = {
                        onNegativeButtonClick.invoke()
                    },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors().copy(containerColor = red),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .heightIn(max = 40.dp)
                ) {
                    Text(
                        text = negativeButtonText,
                        style = MaterialTheme.typography.labelSmall.copy(color = white)
                    )
                }
            }
        }
    }
}


@Composable
@Preview
private fun SmcAlertViewPreview() {
    SmcAlertView()
}

@Composable
fun ShowAlertDialog(
    title: String = "Alert",
    message: String = "something will be here to alert",
    positiveButtonText: String = "Ok",
    negativeButtonText: String = "Cancel",
    onPositiveButtonClick: () -> Unit = {},
    onNegativeButtonClick: () -> Unit = {},
    showDialog: (show: Boolean) -> Unit
) {
    val scope = rememberCoroutineScope()
    Dialog(
        onDismissRequest = {
            showDialog.invoke(false)
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        SmcAlertView(
            title = title,
            message = message,
            positiveButtonText = positiveButtonText,
            negativeButtonText = negativeButtonText,
            onPositiveButtonClick = {
                scope.launch { }.invokeOnCompletion {
                    showDialog.invoke(false)
                }
                onPositiveButtonClick.invoke()
            },
            onNegativeButtonClick = {
                scope.launch { }.invokeOnCompletion {
                    showDialog.invoke(false)
                }
                onNegativeButtonClick.invoke()
            },

            )
    }
}