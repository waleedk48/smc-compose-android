package com.servicemycar.android.ui.screens.drawer.invite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.screens.main.home.composes.FreebiaseCard
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.DottedHorizontalDivider
import com.servicemycar.android.ui.views.clickWithColorRipple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InviteFriendsScreen(
    navController: NavController,
    onDrawerStateChange: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Invite Family & Friends",
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = black,
                            fontSize = 18.sp,
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onDrawerStateChange
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(26.dp, 30.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(color = black)
                                .padding(horizontal = 6.dp, vertical = 6.dp),
                            painter = painterResource(id = R.drawable.ic_menu),
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
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                "Share your referral link, invite a friend and earn money",
                style = MaterialTheme.typography.bodyMedium
            )
            12.dp.toheight()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = white),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(45.dp),
                            painter = painterResource(R.drawable.ic_reffer_friend),
                            contentDescription = "Refer a Friend",
                            tint = black
                        )
                        3.dp.toheight()
                        Text(
                            "Share App",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
                DottedHorizontalDivider(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .padding(horizontal = 2.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(containerColor = white),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(45.dp),
                            painter = painterResource(R.drawable.ic_they_signup),
                            contentDescription = "They sign up",
                            tint = black
                        )
                        3.dp.toheight()
                        Text(
                            "They sign up",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
                DottedHorizontalDivider(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .padding(horizontal = 2.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(containerColor = white),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(45.dp),
                            painter = painterResource(R.drawable.ic_earn_money),
                            contentDescription = "Earn Money",
                            tint = black
                        )
                        3.dp.toheight()
                        Text(
                            "Earn Money",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
            }
            20.dp.toheight()
            Text("Earnings", style = MaterialTheme.typography.bodyMedium)
            12.dp.toheight()
            Card(
                colors = CardDefaults.cardColors(containerColor = white),
                shape = RoundedCornerShape(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "529",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = white,
                                fontSize = 16.sp
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .background(
                                    black, RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                                .widthIn(min = 42.dp, max = 42.dp)
                        )
                        5.dp.toheight()
                        Text(
                            "Balance AED",
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 11.sp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "12",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = white,
                                fontSize = 16.sp
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .background(
                                    black, RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                                .widthIn(min = 42.dp, max = 42.dp)
                        )
                        5.dp.toheight()
                        Text(
                            "Signed Up",
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 11.sp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "0",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = white,
                                fontSize = 16.sp
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .background(
                                    black, RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                                .widthIn(min = 42.dp, max = 42.dp)
                        )
                        5.dp.toheight()
                        Text(
                            "Booked",
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 11.sp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            20.dp.toheight()
            Text("Free Major Service", style = MaterialTheme.typography.bodyMedium)
            12.dp.toheight()
            FreebiaseCard(progress = 3, maxProgress = 20)
            20.dp.toheight()
            Text(
                "Press terms and Conditions",
                style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .clickWithColorRipple(
                        black, true
                    ) {

                    },
                textAlign = TextAlign.Center
            )

            20.dp.toheight()
            Text("You Referral code", style = MaterialTheme.typography.bodyMedium)
            6.dp.toheight()
            Card(
                colors = CardDefaults.cardColors(containerColor = white),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    "ADLABA6Y7",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 28.sp),
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth()
                        .clickWithColorRipple(black, true) {

                        },
                    textAlign = TextAlign.Center
                )
            }
            6.dp.toheight()
            Text(
                "Tap to copy",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            20.dp.toheight()
            ElevatedButton(
                onClick = {

                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Share link now",
                    style = MaterialTheme.typography.labelMedium.copy(color = white)
                )
            }
        }
    }

}


@Composable
@Preview
private fun InviteFriendsScreenPreview() {
    InviteFriendsScreen(NavController(LocalContext.current))
}