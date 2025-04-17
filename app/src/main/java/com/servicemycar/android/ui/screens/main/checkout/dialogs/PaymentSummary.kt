package com.servicemycar.android.ui.screens.main.checkout.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.helpers.toheight

@Composable
fun PaymentSummeryView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Payment Summary",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        )
        15.dp.toheight()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Service", style = MaterialTheme.typography.labelMedium)
            Text("199.00 AED", style = MaterialTheme.typography.labelMedium)
        }
        5.dp.toheight()
        HorizontalDivider()
        5.dp.toheight()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Discount", style = MaterialTheme.typography.labelMedium)
            Text("-40.00 AED", style = MaterialTheme.typography.labelMedium)
        }
        5.dp.toheight()
        HorizontalDivider()
        5.dp.toheight()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Government Tax", style = MaterialTheme.typography.labelMedium)
            Text("7.95 AED", style = MaterialTheme.typography.labelMedium)
        }
        5.dp.toheight()
        HorizontalDivider()
        5.dp.toheight()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Total Payable",
                style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp)
            )
            Text("166.95 AED", style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp))
        }
        5.dp.toheight()
        HorizontalDivider()
        15.dp.toheight()
    }
}


@Composable
@Preview(showBackground = true)
private fun PaymentSummeryPreview() {
    PaymentSummeryView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowPaymentSummaryBottomSheet(
    showBottomSheet: (show: Boolean) -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    //val scope = rememberCoroutineScope()
    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.tertiary,
        onDismissRequest = {
            showBottomSheet.invoke(false)
        }, sheetState = sheetState
    ) {
        PaymentSummeryView()
    }
}