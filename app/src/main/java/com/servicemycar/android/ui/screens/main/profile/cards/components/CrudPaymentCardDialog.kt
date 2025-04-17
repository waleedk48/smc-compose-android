package com.servicemycar.android.ui.screens.main.profile.cards.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.theme.white
import kotlinx.coroutines.launch


@Composable
fun CrudPaymentCardView(modifier: Modifier = Modifier, onCancelClick:() -> Unit = {}, onActionClick:() -> Unit = {}) {
    Card(
        colors = CardDefaults.cardColors(containerColor = white),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Are you sure want\nto delete this card?",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
            10.dp.toheight()
            Text(
                "This card will be deleted.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            10.dp.toheight()
            Column(
                modifier = Modifier
                    .background(backgroundColor, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        tint = greyDark.copy(alpha = 0.7f),
                        contentDescription = null
                    )
                    4.dp.toWidth()
                    Text(
                        "Credit Card",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = greyDark.copy(alpha = 0.7f),
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                4.dp.toheight()
                Text(
                    "Visa ending in 7860",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 13.sp,
                        color = black
                    )
                )
            }
            20.dp.toheight()
            Row {
                Button(
                    onClick = onActionClick,
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        "Cancel",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = black,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                28.dp.toWidth()
                Button(
                    onClick = onActionClick,
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = red),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        "Delete",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = white,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ShowCrudPaymentDialog(showDialog: (show: Boolean) -> Unit) {
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
        CrudPaymentCardView(
            onActionClick = {
                scope.launch { }.invokeOnCompletion {
                    showDialog.invoke(false)
                }
            },
            onCancelClick = {
                scope.launch { }.invokeOnCompletion {
                    showDialog.invoke(false)
                }
            }
        )
    }
}

@Composable
@Preview
private fun CrudPaymentCardViewPreview() {
    SMCAndroidTheme {
        CrudPaymentCardView(modifier = Modifier.background(white, RoundedCornerShape(4.dp)))
    }

}