package com.servicemycar.android.ui.screens.main.home2.sub_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.screens.main.home.drawer.exploreList_Orders
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple
import com.servicemycar.android.ui.views.dropShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(navController: NavController) {
    Scaffold(
        containerColor = backgroundColor,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = grey)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "MW",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = greyDark.copy(
                                    alpha = 0.8f
                                )
                            ),
                            modifier = Modifier
                                .background(
                                    white, CircleShape
                                )
                                .size(52.dp)
                                .padding(top = 16.dp)
                                .align(Alignment.CenterVertically),
                            textAlign = TextAlign.Center
                        )
                        12.dp.toWidth()
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                "Muhammad Waleed",
                                style = MaterialTheme.typography.labelMedium.copy()
                            )
                            2.dp.toheight()
                            Text(
                                "0529447229",
                                style = MaterialTheme.typography.labelMedium.copy(fontSize = 12.sp)
                            )
                        }
                        8.dp.toWidth(modifier = Modifier.weight(1f))
                        Text(
                            "Edit",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(18.dp),
                                    color = white
                                )
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                        )

                    }
                    6.dp.toheight()
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 4.dp),
                            color = black,
                            progress = { 0.6f },
                            trackColor = white,
                            strokeCap = StrokeCap.Round,
                            gapSize = 2.dp
                        )
                        Text(
                            "60%",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = white
                            ),
                            modifier = Modifier
                                .padding(start = 2.dp)
                                .background(black, CircleShape)
                                .padding(vertical = 2.dp, horizontal = 4.dp)
                        )
                    }
                    4.dp.toheight()
                    Text(
                        "Book five Major services and get the sixth one free! your current progress is 3/5",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            12.dp.toheight()
            Row {
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(4.dp),
                    colors = CardDefaults.cardColors(containerColor = grey)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_wallet_3d),
                            contentDescription = "",
                            modifier = Modifier
                                .size(28.dp)
                                .dropShadow(RoundedCornerShape(8.dp))
                        )
                        12.dp.toWidth()
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                "Balance",
                                style = MaterialTheme.typography.labelMedium.copy(fontSize = 12.sp)
                            )
                            2.dp.toheight()
                            Text(
                                "120 AED",
                                style = MaterialTheme.typography.labelMedium.copy(fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            )


                        }
                    }

                }
                12.dp.toWidth()
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(4.dp),
                    colors = CardDefaults.cardColors(containerColor = grey)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_invite_friend_3d),
                            contentDescription = "",
                            modifier = Modifier
                                .size(28.dp)
                                .dropShadow(RoundedCornerShape(8.dp))
                        )
                        12.dp.toWidth()
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                "Referred Users",
                                style = MaterialTheme.typography.labelMedium.copy(fontSize = 12.sp)
                            )
                            2.dp.toheight()
                            Text(
                                "34",
                                style = MaterialTheme.typography.labelMedium.copy(fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            )


                        }
                    }

                }
            }
            12.dp.toheight()
            Text("Account Details", style = MaterialTheme.typography.labelSmall)
            Card(
                modifier = Modifier.padding(top = 6.dp),
                colors = CardDefaults.cardColors(containerColor = grey),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickWithColorRipple(black, true) {

                            }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_mail_3d),
                            contentDescription = null,
                            modifier = Modifier
                                .size(22.dp)
                                .dropShadow(
                                    shape = RoundedCornerShape(4.dp),
                                    spread = (-4).dp
                                )
                        )
                        12.dp.toWidth()
                        Column {
                            Text(
                                text = "Email",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                            Text(
                                text = "waleedkalyar48@gmail.com",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "Change",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(18.dp),
                                    color = white
                                )
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                        )
                    }
                     HorizontalDivider(
                        thickness = 1.dp,
                        color = black.copy(alpha = 0.1f)
                    )
                }
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickWithColorRipple(black, true) {

                            }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_world_3d),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .size(22.dp)
                                .dropShadow(
                                    shape = RoundedCornerShape(4.dp),
                                    spread = (-4).dp
                                )
                        )
                        12.dp.toWidth()
                        Column {
                            Text(
                                text = "Country",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                            Text(
                                text = "United Arab Emirates",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "Change",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(18.dp),
                                    color = white
                                )
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                        )
                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = black.copy(alpha = 0.1f)
                    )
                }
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickWithColorRipple(black, true) {

                            }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_language_3d),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .size(22.dp)
                                .dropShadow(
                                    shape = RoundedCornerShape(4.dp),
                                    spread = (-4).dp
                                )
                        )
                        12.dp.toWidth()
                        Column {
                            Text(
                                text = "Language",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                            Text(
                                text = "English (UK)",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "Change",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(18.dp),
                                    color = white
                                )
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                        )
                    }
                }
            }
            12.dp.toheight()
            Text("Account Settings", style = MaterialTheme.typography.labelSmall)
            Card(
                modifier = Modifier.padding(top = 6.dp),
                colors = CardDefaults.cardColors(containerColor = grey),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickWithColorRipple(black, true) {

                            }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_credit_card_3d),
                            contentDescription = null,
                            modifier = Modifier
                                .size(22.dp)
                                .dropShadow(
                                    shape = RoundedCornerShape(4.dp),
                                    spread = (-4).dp
                                )
                        )
                        12.dp.toWidth()
                        Column {
                            Text(
                                text = "Payment Cards",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                            Text(
                                text = "3 cards attached",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "View",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(18.dp),
                                    color = white
                                )
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                                .clickWithColorRipple(black,true){
                                    navController.navigate(NavigationItem.PaymentCards)
                                }
                        )
                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = black.copy(alpha = 0.1f)
                    )
                }
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickWithColorRipple(black, true) {

                            }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_notifications_3d),
                            contentDescription = null,
                            modifier = Modifier
                                .size(22.dp)
                                .dropShadow(
                                    shape = RoundedCornerShape(4.dp),
                                    spread = (-4).dp
                                )
                        )
                        12.dp.toWidth()
                        Column {
                            Text(
                                text = "Notifications",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                            Text(
                                text = "Allow push notifications",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "Block",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(18.dp),
                                    color = white
                                )
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            12.dp.toheight()
            Text("Account Status", style = MaterialTheme.typography.labelSmall)
            Card(
                modifier = Modifier.padding(top = 6.dp),
                colors = CardDefaults.cardColors(containerColor = grey),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(4.dp)
            ){
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickWithColorRipple(black, true) {

                            }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_delete_3d),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .size(22.dp)
                                .dropShadow(
                                    shape = RoundedCornerShape(4.dp),
                                    spread = (-4).dp
                                )
                        )
                        12.dp.toWidth()
                        Column {
                            Text(
                                text = "Delete",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                            Text(
                                text = "Delete My Account",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = 12.sp,
                                    color = black
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "Delete",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp,
                                color = red
                            ),
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(18.dp),
                                    color = white
                                )
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview
private fun AccountScreenPreview() {
    SMCAndroidTheme {
        AccountScreen(NavController(LocalContext.current))
    }

}