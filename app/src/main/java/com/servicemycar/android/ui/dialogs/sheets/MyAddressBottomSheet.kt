package com.servicemycar.android.ui.dialogs.sheets

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.servicemycar.android.ui.dialogs.sheets.widgets.MyAddressItemView
import com.servicemycar.android.ui.dialogs.sheets.widgets.MyCarItemView
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white
import kotlinx.coroutines.launch




@Composable
fun MyAddressBottomSheetView(onSelectAddress: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.7f)
            .background(white, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp),
        ) {
            val (title, btnAdd) = createRefs()
            Text(
                "My Addresses",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.constrainAs(title) {
                    this.apply {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                },
            )
            Text("Add Address",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = white,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .background(black, RoundedCornerShape(4.dp))
                    .padding(PaddingValues(horizontal = 12.dp, vertical = 6.dp))
                    .clickable {

                    }
                    .constrainAs(btnAdd) {
                        this.apply {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                    }
            )
        }
        LazyColumn {
            items((1..3).map { it.toString() }.toList()) {
                MyAddressItemView {
                    onSelectAddress.invoke()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowMyAddressBottomSheet(
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
        MyAddressBottomSheetView {
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
@Preview(showBackground = false)
private fun MyAddressBottomSheetViewPreview() {
    MyAddressBottomSheetView {}
}