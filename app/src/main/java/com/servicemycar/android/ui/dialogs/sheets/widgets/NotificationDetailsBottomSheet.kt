package com.servicemycar.android.ui.dialogs.sheets.widgets

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.servicemycar.android.R
import com.servicemycar.android.ui.dialogs.sheets.widgets.MyCarItemView
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple
import kotlinx.coroutines.launch


@Composable
fun NotificationDetailsBottomSheetView(onSelectCar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.7f)
            .background(white, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .padding(vertical = 6.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text("Share",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = white,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .background(black, RoundedCornerShape(4.dp))
                    .padding(PaddingValues(horizontal = 12.dp, vertical = 6.dp))
                    .clickWithColorRipple(white, false) {}
            )
        }
        5.dp.toheight()
        Image(
            painter = painterResource(R.drawable.bg_placeholder),
            contentDescription = "Promotion Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
        )
        15.dp.toheight()
        Text(
            "Happy Diwali from Service My Car 11/11/2024!",
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.SemiBold,
                color = black,
            )
        )
        8.dp.toheight()
        Text(
            "May your Diwali be full of lights and your car full of life!\nGet is Serviced and ready for smooth drives during the festivals.\nBook a Major Service for AED 349 Now.",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Normal,
                color = black,
            )
        )
        25.dp.toheight()
        ElevatedButton(
            onClick = {

            },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors().copy(containerColor = black),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Apply Coupon MEGA30",
                style = MaterialTheme.typography.labelMedium.copy(color = white)
            )
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowNotificationDetailsBottomSheet(
    showBottomSheet: (show: Boolean) -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.tertiary,
        onDismissRequest = {
            showBottomSheet.invoke(false)
        }, sheetState = sheetState
    ) {
        NotificationDetailsBottomSheetView {
            scope.launch { sheetState.hide() }.invokeOnCompletion {
                if (!sheetState.isVisible) {
                    showBottomSheet.invoke(false)
                }
            }
        }

//
    }
}

@Composable
@Preview(showBackground = true)
private fun NotificationDetailsBottomSheetViewPreview() {
    NotificationDetailsBottomSheetView {}
}