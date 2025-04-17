package com.servicemycar.android.ui.screens.main.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.models.ServiceModel
import com.servicemycar.android.ui.dialogs.popups.ShowAlertDialog
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.screens.main.checkout.dialogs.ShowInfoDialog
import com.servicemycar.android.ui.screens.main.checkout.dialogs.ShowPaymentSummaryBottomSheet
import com.servicemycar.android.ui.screens.main.checkout.items.ItemAdditionalService
import com.servicemycar.android.ui.screens.main.checkout.items.ItemPaymentMethod
import com.servicemycar.android.ui.screens.main.checkout.widgets.DiscountInputField
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutScreen(
    navController: NavController,
    serviceModel: ServiceModel
) {
    val extraServicesSelected = remember { mutableStateListOf<Int>() }
    var paymentMethodSelected by remember { mutableIntStateOf(-1) }

    var showPaymentSummaryBottomSheet by remember { mutableStateOf(false) }
    var showInfoDialog by remember { mutableStateOf(false) }
    var showGoBackAlert by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Checkout",
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
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
                actions = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = black,
                        modifier = Modifier
                            .padding(4.dp)
                            .clickWithColorRipple(black, true) {
                                showGoBackAlert = true
                            }
                    )
                    8.dp.toWidth()
                }
            )
        },
        containerColor = backgroundColor,
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        if (showPaymentSummaryBottomSheet) ShowPaymentSummaryBottomSheet {
            showPaymentSummaryBottomSheet = it
        }
        if (showInfoDialog) ShowInfoDialog {
            showInfoDialog = it
        }

        if (showGoBackAlert) ShowAlertDialog(
            title = "ServiceMyCar",
            message = "Are you sure you wat to return to the homepage?",
            onPositiveButtonClick = {
                navController.navigate(NavigationItem.Home) {
                    popUpTo(0) {
                        inclusive = true
                    }
                }
            }
        ) {
            showGoBackAlert = it
        }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                "Additional services",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            6.dp.toheight()
            LazyVerticalGrid(
                modifier = Modifier.heightIn(max = 300.dp),
                columns = GridCells.Fixed(4)
            ) {
                items(8) { index ->
                    ItemAdditionalService(
                        isSelected = extraServicesSelected.contains(index),
                        onItemSelect = {
                            if (extraServicesSelected.contains(index)) extraServicesSelected.remove(
                                index
                            ) else extraServicesSelected.add(index)
                        },
                        onMoreInfoClick = {
                            showInfoDialog = true
                        }

                    )

                }
            }
            12.dp.toheight()
            Text(
                "Have a Discount Code?",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            6.dp.toheight()
            DiscountInputField(modifier = Modifier.fillMaxWidth())
            12.dp.toheight()
            Text(
                "Select Payment method",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            2.dp.toheight()
            LazyColumn(modifier = Modifier.heightIn(max = 200.dp)) {
                items(2) { index ->
                    ItemPaymentMethod(
                        icon = if (index != 0) Icons.Default.Money else Icons.Default.CreditCard,
                        title = if (index != 0) "Pay by Cash" else "Pay by Card",
                        isSelected = paymentMethodSelected == index,
                        onSelect = { selected ->
                            paymentMethodSelected = if (selected) {
                                index
                            } else -1
                        }
                    )
                }
            }
            12.dp.toheight()
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Total", style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp))
                Text(
                    "166.95 AED",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 24.sp)
                )
            }
            Text(
                "View Summery",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.End)
                    .padding(horizontal = 6.dp, vertical = 4.dp)
                    .clickWithColorRipple(black, true) {
                        showPaymentSummaryBottomSheet = true
                    },
                textAlign = TextAlign.End
            )

            10.dp.toheight()
            ElevatedButton(
                onClick = {
                    //navController.navigate(NavigationItem.Checkout(service = serviceModel))
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Pay Now",
                    style = MaterialTheme.typography.labelMedium.copy(color = white)
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun CheckOutScreenPreview() {
    CheckOutScreen(
        navController = NavController(LocalContext.current),
        serviceModel = ServiceModel(id = "", name = "Major Service")
    )
}