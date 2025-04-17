package com.servicemycar.android.ui.screens.main.profile.cards.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.SMCInputField
import kotlinx.coroutines.launch


@Composable
fun AddPaymentCardView(onAddCard: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(white)
            .padding(12.dp)
    ) {
        Text("Card holder name", style = MaterialTheme.typography.bodyMedium)
        2.dp.toheight()
        SMCInputField(placeHolder = "Card holder name", backgroundColor = grey)
        12.dp.toheight()
        Text("Card number", style = MaterialTheme.typography.bodyMedium)
        2.dp.toheight()
        SMCInputField(placeHolder = "Card number", backgroundColor = grey)
        12.dp.toheight()
        Row {
            Column(modifier = Modifier.weight(1f)) {
                Text("Expire Date", style = MaterialTheme.typography.bodyMedium)
                2.dp.toheight()
                SMCInputField(placeHolder = "MM/YY", backgroundColor = grey)
            }
            24.dp.toWidth()
            Column(modifier = Modifier.weight(1f)) {
                Text("CVC", style = MaterialTheme.typography.bodyMedium)
                2.dp.toheight()
                SMCInputField(placeHolder = "CVC", backgroundColor = grey)
            }
        }
        24.dp.toheight()
        Button(onClick = {onAddCard.invoke()}, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(4.dp)) {
            Text("Save New Card", style = MaterialTheme.typography.labelSmall.copy(color = white))
        }

    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ShowAddCardBottomSheet(showBottomSheet: (show: Boolean) -> Unit) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.tertiary,
        onDismissRequest = {
            showBottomSheet.invoke(false)
        }, sheetState = sheetState
    ) {
        AddPaymentCardView {
            scope.launch() {
                sheetState.hide()
            }.invokeOnCompletion {
                if (!sheetState.isVisible) {
                    showBottomSheet.invoke(false)
                }
            }
        }
    }
}


@Composable
@Preview
private fun AddPaymentCardViewPreview() {
    SMCAndroidTheme {
        AddPaymentCardView{}
    }

}