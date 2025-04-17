package com.servicemycar.android.ui.screens.drawer.support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple
import com.servicemycar.android.ui.views.dropShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportScreen(navController: NavController) {
    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundColor),
                navigationIcon = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = black,
                        contentDescription = "go back",
                        modifier = Modifier
                            .padding(8.dp)
                            .background(
                                white, RoundedCornerShape(4.dp)
                            )
                            .padding(5.dp)
                            .clickWithColorRipple(black, true) {
                                navController.navigateUp()
                            })
                },
                title = {
                    Text(
                        "Support",
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 19.sp)
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(12.dp)
        ) {
            20.dp.toheight()
            Icon(
                painter = painterResource(R.drawable.img_call_center),
                contentDescription = "",
                modifier = Modifier
                    .size(140.dp)
                    .align(Alignment.CenterHorizontally),
                tint = green
            )
            30.dp.toheight()
            Text(
                "Hello, How can we\nHelp you?",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontSize = 22.sp,
                    lineHeight = 26.sp
                ),
                textAlign = TextAlign.Center
            )
            60.dp.toheight()

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = white),
                elevation = CardDefaults.cardElevation(0.2.dp)
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 14.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.img_call_center),
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp),
                        tint = black
                    )
                    12.dp.toWidth()
                    Text(
                        "Contact Live Chat",
                        style = MaterialTheme.typography.labelMedium.copy(fontSize = 14.sp)
                    )
                    25.dp.toWidth(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        tint = black,
                        contentDescription = "",
                        modifier = Modifier.size(18.dp)
                    )

                }
            }
            20.dp.toheight()
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = white),
                elevation = CardDefaults.cardElevation(0.2.dp)
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 14.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp),
                        tint = black
                    )
                    12.dp.toWidth()
                    Text(
                        "Send us an E-mail",
                        style = MaterialTheme.typography.labelMedium.copy(fontSize = 14.sp)
                    )
                    25.dp.toWidth(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        tint = black,
                        contentDescription = "",
                        modifier = Modifier.size(18.dp)
                    )

                }
            }
            20.dp.toheight()
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = white),
                elevation = CardDefaults.cardElevation(0.2.dp)
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.QuestionMark,
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp)
                            .background(shape = RoundedCornerShape(4.dp), color = black)
                            .padding(2.dp),
                        tint = white
                    )
                    12.dp.toWidth()
                    Text(
                        "FAQs",
                        style = MaterialTheme.typography.labelMedium.copy(fontSize = 14.sp)
                    )
                    25.dp.toWidth(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        tint = black,
                        contentDescription = "",
                        modifier = Modifier.size(22.dp)
                    )

                }
            }
        }
    }
}


@Composable
@Preview
private fun SupportScreenPreview() {
    SMCAndroidTheme {
        SupportScreen(NavController(LocalContext.current))
    }

}