package com.servicemycar.android.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.transparent
import com.servicemycar.android.ui.theme.white


data class CountryModel(
    var id: Int,
    var code: String,
    var flag: Int,
    var country: String
)


@Composable
fun SMCPhonePicker(
    modifier: Modifier = Modifier,
    backgroundColor: Color = white,
    showFlag:Boolean = true,
    countryMode:Boolean = false,
) {

    val list = remember {
        mutableStateListOf(
            CountryModel(id = 1, country = "United Arab Emirates", code = "+971", flag = R.drawable.ic_flag_uae),
            CountryModel(id = 2, country = "Oman", code = "+968", flag = R.drawable.ic_flag_oman),
            CountryModel(id = 3, country = "United Kingdom", code = "+44", flag = R.drawable.ic_flag_uk),
            CountryModel(id = 4, country = "Qatar", code = "+974", flag = R.drawable.ic_flag_qatar),
        )
    }

    var selected by remember { mutableIntStateOf(0) }
    var expanded by remember { mutableStateOf(false) } // initial value
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    Box {
        Column {

            Row (
                modifier= modifier.background(backgroundColor, RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .onGloballyPositioned {
                        textFieldSize = it.size.toSize()
                    }
            ){
                if (showFlag) {
                    Image(
                        painter = painterResource(list[selected].flag),
                        list[selected].country,
                        modifier = Modifier.size(16.dp)
                    )
                    5.dp.toWidth()
                }
                Text(if (countryMode) list[selected].country else list[selected].code, style = MaterialTheme.typography.bodyMedium)
                8.dp.toWidth()
                Spacer(modifier= Modifier.weight(1f))
                Icon(
                    if (expanded) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown,
                    null,
                    tint = black,
                    modifier = Modifier.size(18.dp)
                )
            }





            DropdownMenu(
                modifier = modifier
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
                            interactionSource = null,
                            onClick = {
                                selected = entry.id - 1
                                expanded = false
                            },
                            text = {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Row {
                                        Image(
                                            painter = painterResource(entry.flag),
                                            contentDescription = entry.country,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        5.dp.toWidth()
                                        Text(
                                            text = (if(countryMode) entry.country else entry.code),
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Medium
                                            ),
                                            modifier = Modifier
                                                .wrapContentWidth()
                                        )
                                    }
                                }
                            }
                        )
                        Box(modifier = Modifier.padding(horizontal = 8.dp)) {
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


@Composable
@Preview(showBackground = true)
fun SMCPhonePickerPreview() {
    SMCPhonePicker(modifier = Modifier.fillMaxWidth())
}