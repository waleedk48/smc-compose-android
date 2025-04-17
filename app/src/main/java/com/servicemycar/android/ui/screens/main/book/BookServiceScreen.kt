package com.servicemycar.android.ui.screens.main.book

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirportShuttle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowDropDown
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.models.ServiceModel
import com.servicemycar.android.ui.dialogs.sheets.ShowMyAddressBottomSheet
import com.servicemycar.android.ui.dialogs.sheets.ShowMyCarsBottomSheet
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.SMCDatePickerDialog
import com.servicemycar.android.ui.views.SMCSlotPickSpinner
import com.servicemycar.android.ui.views.SmcListTile
import com.servicemycar.android.ui.views.clickWithColorRipple
import com.servicemycar.android.utils.toDate_dd_mm_yyyy
import timber.log.Timber


data class DateModel(
    var date: Int = 17,
    var month: String = "Oct",
    var dayOfWeek: String = "Thursday",
    var dateTime: Long = System.currentTimeMillis()
)

data class SlotModel(
    var id: Int = 0,
    var time: String = "No time available",
    var booked: Boolean = false
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookServiceScreen(
    navController: NavController,
    serviceModel: ServiceModel
) {
    var showMyCarsBottomSheet by remember { mutableStateOf(false) }
    var showAddressBottomSheet by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDateState by remember { mutableStateOf(DateModel()) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Major Service",
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
        if (showMyCarsBottomSheet) ShowMyCarsBottomSheet {
            showMyCarsBottomSheet = it
        }

        if (showAddressBottomSheet) ShowMyAddressBottomSheet {
            showAddressBottomSheet = it
        }

        if (showDatePicker) SMCDatePickerDialog(onConfirm = { dateModel ->
            Timber.tag("BookService")
                .d("BookServiceScreen: ${dateModel.date} - ${dateModel.month} - ${dateModel.dayOfWeek}")
            selectedDateState = dateModel
            showDatePicker = false
        }, onDismiss = {
            showDatePicker = false
        })

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                "Select Vehicle",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = black,
                    fontWeight = FontWeight.Bold
                )
            )
            8.dp.toheight()
            SmcListTile(
                leading = {
                    Icon(
                        modifier = Modifier
                            .size(32.dp, 32.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp, vertical = 6.dp),
                        imageVector = Icons.Default.AirportShuttle,
                        tint = black,
                        contentDescription = null
                    )
                },
                title = {
                    Text(
                        "Acura MDX 2013",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                },
                subTitle = {
                    Text(
                        "00-54446",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )
                    )
                },
                trailing = {
                    ElevatedButton(
                        onClick = {
                            showMyCarsBottomSheet = true
                        },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                        modifier = Modifier
                            .wrapContentWidth()
                            .width(90.dp)
                            .height(30.dp)
                    ) {
                        Text(
                            text = "Change",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = white,
                                fontSize = 10.sp
                            )
                        )
                    }
                }
            )
            25.dp.toheight()
            Text(
                "Collection Address",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = black,
                    fontWeight = FontWeight.Bold
                )
            )
            8.dp.toheight()
            SmcListTile(
                title = {
                    Text(
                        "Autofix, Auto Rent, SMC - Al Qouz Ind area 4, Dubai United Arab Emirates",
                        modifier = Modifier.fillMaxWidth(0.7f),
                        overflow = TextOverflow.Visible,
                        maxLines = 3,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )
                    )
                },
                trailing = {
                    ElevatedButton(
                        onClick = {
                            showAddressBottomSheet = true
                        },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                        modifier = Modifier
                            .wrapContentWidth()
                            .width(90.dp)
                            .height(30.dp)
                    ) {
                        Text(
                            text = "Change",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = white,
                                fontSize = 10.sp
                            )
                        )
                    }
                }
            )
            25.dp.toheight()
            Text(
                "Delivery Address",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = black,
                    fontWeight = FontWeight.Bold
                )
            )
            8.dp.toheight()
            SmcListTile(
                title = {
                    Text(
                        "Autofix, Auto Rent, SMC - Al Qouz Ind area 4, Dubai United Arab Emirates",
                        modifier = Modifier.fillMaxWidth(0.7f),
                        overflow = TextOverflow.Visible,
                        maxLines = 3,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )
                    )
                },
                trailing = {
                    ElevatedButton(
                        onClick = {
                            showAddressBottomSheet = true
                        },
                        shape = RoundedCornerShape(4.dp),
                        contentPadding = PaddingValues(
                            start = 1.dp,
                            top = 1.dp,
                            end = 1.dp,
                            bottom = 1.dp,
                        ),
                        colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                        modifier = Modifier
                            .wrapContentWidth()
                            .width(90.dp)
                            .height(30.dp)
                    ) {
                        Text(
                            text = "Change",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = white,
                                fontSize = 10.sp
                            )
                        )
                    }
                }
            )
            25.dp.toheight()
            Text(
                "Select Date & Time",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = black,
                    fontWeight = FontWeight.Bold
                )
            )
            8.dp.toheight()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                SmcListTile(
                    onClick = {
                        showDatePicker = true
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.45f)
                        .height(55.dp),
                    leading = {
                        Text(
                            "${selectedDateState.date}",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontSize = 26.sp,
                                color = black
                            )
                        )
                    },
                    title = {
                        Text(
                            selectedDateState.month,
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                        )
                    },
                    subTitle = {
                        Text(
                            selectedDateState.dayOfWeek,
                            style = MaterialTheme.typography.bodySmall.copy(color = greyDark)
                        )
                    },
                    trailing = {
                        Icon(
                            modifier = Modifier.clickWithColorRipple(black, true) {
                                showDatePicker = true
                            },
                            imageVector = Icons.Default.ArrowDropDown,
                            tint = black,
                            contentDescription = null,
                        )
                    }
                )
                SMCSlotPickSpinner(
                    modifier = Modifier
                        .fillMaxWidth(0.90f)
                        .height(55.dp),
                    list = listOf(
                        SlotModel(id = 1, time = "8AM to 9AM", booked = true),
                        SlotModel(id = 2, time = "9AM to 10AM", booked = true),
                        SlotModel(id = 3, time = "10AM to 11AM", booked = true),
                        SlotModel(id = 4, time = "11AM to 12AM", booked = true),
                        SlotModel(id = 5, time = "12AM to 01PM", booked = false),
                        SlotModel(id = 6, time = "01PM to 02PM", booked = false),
                        SlotModel(id = 7, time = "02PM to 03PM", booked = false),
                        SlotModel(id = 8, time = "03PM to 04PM", booked = false),
                        SlotModel(id = 9, time = "04PM to 05PM", booked = false),
                        SlotModel(id = 10, time = "05PM to 06PM", booked = false),
                        SlotModel(id = 11, time = "06PM to 07PM", booked = false),
                        SlotModel(id = 12, time = "07PM to 08PM", booked = false),
                    ),
                    preselected = SlotModel(id = 3, time = "10AM to 11AM", booked = true),
                    onSelectionChanged = { _ ->

                    }
                )

//                SmcListTile(
//                    modifier = Modifier
//                        .fillMaxWidth(0.85f)
//                        .height(55.dp),
//                    title = { Text("Time Slot", style = MaterialTheme.typography.bodyMedium) },
//                    trailing = {
//                        Icon(
//                            imageVector = Icons.Default.ArrowDropDown,
//                            tint = black,
//                            contentDescription = null,
//                        )
//                    }
//                )
            }

            25.dp.toheight()
            Text(
                "Estimate Delivery Time",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = black,
                    fontWeight = FontWeight.Bold
                )
            )
            8.dp.toheight()
            SmcListTile(
                title = {
                    Text(
                        "Your vehicle will be ready by ${selectedDateState.dateTime.toDate_dd_mm_yyyy()} or earlier subject to additional repairs",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            ElevatedButton(
                onClick = {
                    navController.navigate(NavigationItem.OrderInformation(service = serviceModel))
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
@Preview
fun BookServiceScreenPreview() {
    BookServiceScreen(
        navController = NavController(LocalContext.current),
        serviceModel = ServiceModel(id = "", name = "Major Service")
    )
}