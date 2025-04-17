package com.servicemycar.android.ui.screens.drawer.myservices.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.DirectionsCarFilled
import androidx.compose.material.icons.filled.LocationSearching
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple
import com.servicemycar.android.ui.views.dropShadow

@Composable
fun ItemService() {
    Box(modifier = Modifier.padding(vertical = 5.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = white),
            shape = RoundedCornerShape(4.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth()
                ) {
                    Column(modifier = Modifier.weight(1.5f)) {
                        Text(
                            "Service Date & Type",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Text(
                            "08 Nov 2024, 12:30 PM",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = black
                            )
                        )
                        6.dp.toheight()
                        Text(
                            "Ref No: 2314G45",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = black
                            ),
                            modifier = Modifier
                                .background(
                                    grey, shape = RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                        16.dp.toheight()
                        Text(
                            "Service Details:",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        2.dp.toheight()
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.DirectionsCarFilled,
                                contentDescription = null,
                                tint = greyDark,
                                modifier = Modifier.size(20.dp)
                            )
                            4.dp.toWidth()
                            Text(
                                "Vehicle: ",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp,
                                    color = black
                                )
                            )
                            2.dp.toWidth()
                            Text(
                                "Nissan Sunny",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = black
                                ),
                            )
                        }
                        4.dp.toheight()
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Numbers,
                                contentDescription = null,
                                tint = greyDark,
                                modifier = Modifier.size(20.dp)
                            )
                            4.dp.toWidth()
                            Text(
                                "Plate No: ",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp,
                                    color = black
                                )
                            )
                            2.dp.toWidth()
                            Text(
                                "A-1234",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = black
                                ),

                                )
                        }
                        4.dp.toheight()
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = null,
                                tint = greyDark,
                                modifier = Modifier.size(20.dp)
                            )
                            4.dp.toWidth()
                            Text(
                                "Service Package: ",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp,
                                    color = black
                                )
                            )
                            2.dp.toWidth()
                            Text(
                                "Major Service",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = black
                                ),

                                )
                        }
                        4.dp.toheight()
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.LocationSearching,
                                contentDescription = null,
                                tint = greyDark,
                                modifier = Modifier.size(20.dp)
                            )
                            4.dp.toWidth()
                            Text(
                                "Montrose Tower C, Al-Barsha Dubai",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = black
                                ),

                                )
                        }
                        4.dp.toheight()
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.MyLocation,
                                contentDescription = null,
                                tint = greyDark,
                                modifier = Modifier.size(20.dp)
                            )
                            4.dp.toWidth()

                            Text(
                                "Elite Business Center Al-Barsha Dubai",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = black
                                ),

                                )
                        }
                    }
                    Column(
                        modifier = Modifier.weight(0.5f),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Price\n44.59 AED",
                            style = MaterialTheme.typography.labelLarge.copy(fontSize = 14.sp),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .background(
                                    color = grey,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 4.dp, vertical = 2.dp)
                        )
                        180.dp.toheight()
                        Text(
                            "View More",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontSize = 11.sp,
                                color = white
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .background(
                                    // width = 1.dp,
                                    color = black,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 8.dp, vertical = 6.dp)
                                .clickWithColorRipple(black, true) {

                                }
                        )

                    }
                }
            }

        }
    }
}

@Composable
fun ItemService2(isHistory: Boolean = false) {
    ConstraintLayout(modifier = Modifier.padding(vertical = 6.dp)) {
        val (card, text) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp, bottom = 12.dp)
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            colors = CardDefaults.cardColors(containerColor = white),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_repairs_3d),
                        contentDescription = "service",
                        modifier = Modifier
                            .size(24.dp)
                            .dropShadow(
                                spread = (-4).dp,
                                shape = RoundedCornerShape(4.dp)
                            )
                    )
                    12.dp.toWidth()
                    Column {
                        Text("Major Service", style = MaterialTheme.typography.labelLarge)
                        Text("12 April 2024, 15:45", style = MaterialTheme.typography.bodySmall)
                    }
                    2.dp.toWidth(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(grey, RoundedCornerShape(8.dp))
                            .padding(4.dp)
                    ) {
                        Image(
                            painter = painterResource(if (isHistory) R.drawable.ic_done_3d else R.drawable.ic_waiting_clock_3d),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        4.dp.toWidth()
                        Text(
                            if (isHistory) "Delivered" else "Waiting for Report",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = black
                            )
                        )
                    }
                }
                12.dp.toheight()
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            grey.copy(alpha = 0.3f), RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_car_3d),
                        contentDescription = null,
                        modifier = Modifier
                            .size(22.dp)
                            .dropShadow(
                                shape = RoundedCornerShape(4.dp),
                                spread = (-4).dp
                            )
                    )
                    16.dp.toWidth()
                    Column {
                        Text(
                            text = "Nissan Altima",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontSize = 13.sp,
                                color = black
                            )
                        )
                        Text(
                            text = "AA 45231",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontSize = 11.sp,
                                color = black
                            )
                        )
                    }
                }
                12.dp.toheight()
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            grey.copy(alpha = 0.3f), RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                ) {


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_location_3d_pickup),
                            contentDescription = null,
                            modifier = Modifier
                                .size(22.dp)
                                .dropShadow(
                                    shape = RoundedCornerShape(4.dp),
                                    spread = (-4).dp
                                )
                        )
                        8.dp.toWidth()
                        Column {
                            Text(
                                text = "Pickup",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 11.sp,
                                    color = greyDark,
                                    fontWeight = FontWeight.Normal
                                )
                            )
                            Text(
                                text = "Al Mosa tower 2, Dubai",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = 12.sp,
                                    color = black,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    }
                    6.dp.toheight()
                    HorizontalDivider(thickness = 0.4.dp, color = grey)
                    6.dp.toheight()
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.ic_location_3d_drop),
                            contentDescription = null,
                            modifier = Modifier
                                .size(22.dp)
                                .dropShadow(
                                    shape = RoundedCornerShape(4.dp),
                                    spread = (-4).dp
                                )
                        )
                        8.dp.toWidth()
                        Column {
                            Text(
                                text = "Delivery",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 11.sp,
                                    color = greyDark,
                                    fontWeight = FontWeight.Normal
                                )
                            )
                            Text(
                                text = "Al Qouz Ind. Area 4, Dubai",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = 12.sp,
                                    color = black,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    }

                }
                16.dp.toheight()
            }
        }
        Row(
            modifier = Modifier
                .padding(end = 8.dp, top = 12.dp)
                .zIndex(1f)
                .constrainAs(text) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "240 AED",
                style = MaterialTheme.typography.labelMedium.copy(color = white, fontSize = 11.sp),
                modifier = Modifier

                    .background(
                        black, RoundedCornerShape(8.dp)
                    )
                    .padding(4.dp)

            )
            12.dp.toWidth()
            Icon(imageVector = Icons.Default.ArrowCircleRight,
                tint = black,
                contentDescription = "details",
                modifier = Modifier
                    .size(28.dp)
                    .clickWithColorRipple(
                        green, true
                    ) {

                    })
        }

    }
}

@Composable
@Preview(showBackground = false)
private fun ItemServicePreview() {
    SMCAndroidTheme {
        ItemService2(isHistory = true)
    }

}