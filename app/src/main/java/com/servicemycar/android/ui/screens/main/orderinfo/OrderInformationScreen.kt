package com.servicemycar.android.ui.screens.main.orderinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.models.ServiceModel
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.greyDisabled
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.ConcernInputField
import com.servicemycar.android.ui.views.SmcListTile
import com.servicemycar.android.ui.views.toWord

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderInformationScreen(
    navController: NavController,
    serviceModel: ServiceModel
) {
    var afterMarketSelected by remember { mutableStateOf(true) }
    var genuineSelected by remember { mutableStateOf(false) }
    var concernsCount by remember { mutableIntStateOf(3) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Order Information",
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
                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                "Select Parts",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            8.dp.toheight()
            SmcListTile(
                onClick = {
                    afterMarketSelected = !afterMarketSelected
                    if (afterMarketSelected) {
                        genuineSelected = false
                    }
                },
                cardBackgroundColor = if (afterMarketSelected) black else white,
                title = {
                    Text(
                        "After Market Parts",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 14.sp,
                            color = if (afterMarketSelected) white else black
                        )
                    )
                },
                subTitle = {
                    Text(
                        "Aftermarket parts will be the sourced with the highest quality and lowest price making sure we save you as much money as we can",
                        modifier = Modifier.fillMaxWidth(fraction = 0.90f),
                        minLines = 3,
                        maxLines = 3,
                        style = MaterialTheme.typography.bodySmall.copy(color = if (afterMarketSelected) grey else greyDark)
                    )
                },
                trailing = {
                    Checkbox(
                        modifier = Modifier,
                        checked = afterMarketSelected,
                        colors = CheckboxDefaults.colors(
                            checkedColor = white,
                            checkmarkColor = black,
                            uncheckedColor = black
                        ),
                        onCheckedChange = { isChecked ->
                            afterMarketSelected = isChecked
                            if (isChecked) {
                                genuineSelected = false
                            }
                        },

                        )
                }
            )
            16.dp.toheight()
            SmcListTile(
                onClick = {
                    genuineSelected = !genuineSelected
                    if (genuineSelected) {
                        afterMarketSelected = false
                    }
                },
                cardBackgroundColor = if (genuineSelected) black else white,
                title = {
                    Text(
                        "Genuine Parts",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 14.sp,
                            color = if (genuineSelected) white else black
                        )
                    )
                },
                subTitle = {
                    Text(

                        "Genuine parts are what vehicle manufactures recommended",
                        modifier = Modifier.fillMaxWidth(fraction = 0.90f),
                        minLines = 3,
                        maxLines = 3,
                        style = MaterialTheme.typography.bodySmall.copy(color = if (genuineSelected) grey else greyDark)
                    )
                },
                trailing = {
                    Checkbox(
                        modifier = Modifier,
                        checked = genuineSelected,
                        colors = CheckboxDefaults.colors(
                            checkedColor = white,
                            checkmarkColor = black,
                            uncheckedColor = black
                        ),
                        onCheckedChange = { isChecked ->
                            genuineSelected = isChecked
                            if (isChecked) {
                                afterMarketSelected = false
                            }
                        },

                        )
                }
            )
            24.dp.toheight()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Concerns",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = black,
                        fontSize = 16.sp
                    )
                )
                Button(
                    modifier = Modifier.height(30.dp),
                    enabled = concernsCount < 5,
                    onClick = {
                        if (concernsCount < 5) {
                            concernsCount++
                        } else concernsCount = 3
                    },
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = black,
                        disabledContainerColor = greyDisabled
                    )
                ) {
                    Text("Add", style = MaterialTheme.typography.bodySmall.copy(color = white))
                }
            }
            8.dp.toheight()
            Text(
                "Please list any concerns you have for your car that you would like us to check",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp)
            )
            12.dp.toheight()
            for (i in 0 until concernsCount) {
                6.dp.toheight()
                ConcernInputField(placeHolder = "Concern ${(i + 1).toWord()}")
            }
            Spacer(modifier = Modifier.weight(1f))
            20.dp.toheight()
            ElevatedButton(
                onClick = {
                    navController.navigate(NavigationItem.Checkout(service = serviceModel))
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.labelMedium.copy(color = white)
                )
            }


        }
    }
}

@Composable
@Preview(showBackground = true)
private fun OrderInformationScreenPreview() {
    OrderInformationScreen(
        navController = NavController(LocalContext.current),
        serviceModel = ServiceModel(id = "", name = "Major Service")
    )
}