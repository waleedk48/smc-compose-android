package com.servicemycar.android.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.screens.main.book.SlotModel
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.theme.transparent
import com.servicemycar.android.ui.theme.white


@Composable
fun SMCSlotPickSpinner(
    modifier: Modifier = Modifier,
    list: List<SlotModel>,
    preselected: SlotModel,
    onSelectionChanged: (selection: SlotModel) -> Unit
) {

    var selected by remember { mutableStateOf(preselected) }
    var expanded by remember { mutableStateOf(false) } // initial value
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    Box {
        Column {
            TextField(
                value = (selected.time),
                onValueChange = {
                    onSelectionChanged.invoke(selected)
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = white,
                    unfocusedContainerColor = white,
                    errorContainerColor = white,
                    focusedIndicatorColor = transparent,
                    unfocusedIndicatorColor = transparent,
                    disabledIndicatorColor = transparent,
                    errorIndicatorColor = transparent
                ),
                shape = RoundedCornerShape(4.dp),
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 13.sp,
                    color = black
                ),
                modifier = modifier.onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
                trailingIcon = { Icon(Icons.Outlined.ArrowDropDown, null) },
                readOnly = true,

                )
            DropdownMenu(
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                    .heightIn(max = 180.dp),
                expanded = expanded,
                containerColor = white,
                onDismissRequest = { expanded = false },
            ) {
                list.forEach { entry ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        DropdownMenuItem(
                            colors = MenuDefaults.itemColors(),
                            modifier = Modifier,
                            enabled = !entry.booked,
                            interactionSource = null,
                            onClick = {
                                selected = entry
                                expanded = false
                            },
                            text = {
                                if (entry.booked){
                                    Column (
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.Start
                                    ){
                                        Text(
                                            text = (entry.time),
                                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp, color = greyDark),
                                            modifier = Modifier
                                                .wrapContentWidth()
                                                .align(Alignment.Start)
                                        )
                                        Text("(Fully Booked)", style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp, color = red),
                                            modifier = Modifier
                                                .wrapContentWidth()
                                                .align(Alignment.Start)
                                        )
                                        //  8.dp.toheight()
                                        //  HorizontalDivider()
                                    }
                                }
                                else Column (
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    horizontalAlignment = Alignment.Start
                                ){
                                    Text(
                                        text = (entry.time),
                                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
                                        modifier = Modifier
                                            .wrapContentWidth()
                                            .align(Alignment.Start)
                                    )
                                    //  8.dp.toheight()
                                    //  HorizontalDivider()
                                }
                            }
                        )
                        Box(modifier = Modifier.padding(horizontal = 12.dp)) {
                            HorizontalDivider()
                        }
                    }

                }
            }
        }

        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(
                    onClick = { expanded = !expanded }
                )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SMCSlotPickSpinner_Preview() {
    MaterialTheme {
       val list = listOf(
           SlotModel(id =1, time ="8AM to 9 AM",  booked = true),
           SlotModel(id =2, time ="9AM to 10 AM",  booked = true),
           SlotModel(id =3, time ="10AM to 11 AM",  booked = true),
           SlotModel(id =4, time ="11AM to 12 AM",  booked = true),
           SlotModel(id =5, time ="12AM to 01 PM",  booked = false),
           SlotModel(id =6, time ="01PM to 02 PM",  booked = false),
           SlotModel(id =7, time ="02PM to 03 PM",  booked = false),
           SlotModel(id =8, time ="03PM to 04 PM",  booked = false),
           SlotModel(id =9, time ="04PM to 05 PM",  booked = false),
           SlotModel(id =10, time ="05PM to 06 PM",  booked = false),
           SlotModel(id =11, time ="06PM to 07 PM",  booked = false),
           SlotModel(id =12, time ="07PM to 08 PM",  booked = false),
        )
        SMCSlotPickSpinner(
            modifier = Modifier,
            list = list,
            preselected = list[1],
            onSelectionChanged = { selected -> /* do something with selected */ }
        )
    }
}