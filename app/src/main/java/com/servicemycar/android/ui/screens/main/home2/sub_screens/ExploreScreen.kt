package com.servicemycar.android.ui.screens.main.home2.sub_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.screens.drawer.DrawerScreens
import com.servicemycar.android.ui.screens.main.home.drawer.exploreList_My
import com.servicemycar.android.ui.screens.main.home.drawer.exploreList_Orders
import com.servicemycar.android.ui.screens.main.home.drawer.exploreList_Support
import com.servicemycar.android.ui.screens.main.home.drawer.exploreList_log
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.views.clickWithColorRipple
import com.servicemycar.android.ui.views.dropShadow

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    onItemSelect:  (item: DrawerScreens) -> Unit = {}
) {
    Scaffold(
        containerColor = backgroundColor,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 12.dp)
        ) {
            12.dp.toheight()
            Text("My Services", style = MaterialTheme.typography.labelSmall)
            Card(
                modifier = Modifier.padding(top = 6.dp),
                colors = CardDefaults.cardColors(containerColor = grey),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 0.dp),
                ) {

                    itemsIndexed(exploreList_Orders) { index, item ->
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickWithColorRipple(black, true) {
                                        onItemSelect.invoke(item.screen)
                                    }
                                    .padding(horizontal = 16.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(item.iconRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(22.dp)
                                        .dropShadow(
                                            shape = RoundedCornerShape(4.dp),
                                            spread = (-4).dp
                                        )
                                )
                                16.dp.toWidth()
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.labelLarge.copy(
                                        fontSize = 13.sp,
                                        color = black
                                    )
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                    tint = black.copy(alpha = 0.5f),
                                    contentDescription = "Next",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            if (index != exploreList_Orders.size - 1) HorizontalDivider(
                                thickness = 1.dp,
                                color = black.copy(alpha = 0.1f)
                            )
                        }
                    }
                }
            }
            12.dp.toheight()
            Text(
                "My Essentials",
                style = MaterialTheme.typography.labelSmall
            )
            Card(
                modifier = Modifier.padding(top = 6.dp),
                colors = CardDefaults.cardColors(containerColor = grey),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 0.dp),
                ) {

                    itemsIndexed(exploreList_My) { index, item ->
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickWithColorRipple(black, true) {
                                        onItemSelect.invoke(item.screen)
                                    }
                                    .padding(horizontal = 16.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(item.iconRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(22.dp)
                                        .dropShadow(
                                            shape = RoundedCornerShape(4.dp),
                                            spread = (-4).dp
                                        )
                                )
                                16.dp.toWidth()
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.labelLarge.copy(
                                        fontSize = 13.sp,
                                        color = black
                                    )
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                    tint = black.copy(alpha = 0.5f),
                                    contentDescription = "Next",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            if (index != exploreList_My.size - 1) HorizontalDivider(
                                thickness = 1.dp,
                                color = black.copy(alpha = 0.1f)
                            )
                        }
                    }
                }
            }

            12.dp.toheight()
            Text(
                "Refer & Support",
                style = MaterialTheme.typography.labelSmall
            )
            Card(
                modifier = Modifier.padding(top = 6.dp),
                colors = CardDefaults.cardColors(containerColor = grey),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 0.dp),
                ) {

                    itemsIndexed(exploreList_Support) { index, item ->
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickWithColorRipple(black, true) {
                                        onItemSelect.invoke(item.screen)
                                    }
                                    .padding(horizontal = 16.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(item.iconRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(22.dp)
                                        .dropShadow(
                                            shape = RoundedCornerShape(4.dp),
                                            spread = (-4).dp
                                        )
                                )
                                16.dp.toWidth()
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.labelLarge.copy(
                                        fontSize = 13.sp,
                                        color = black
                                    )
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                    tint = black.copy(alpha = 0.5f),
                                    contentDescription = "Next",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            if (index != exploreList_Support.size - 1) HorizontalDivider(
                                thickness = 1.dp,
                                color = black.copy(alpha = 0.1f)
                            )
                        }
                    }
                }
            }

            12.dp.toheight()
            Text("Others", style = MaterialTheme.typography.labelSmall)
            Card(
                modifier = Modifier.padding(top = 6.dp),
                colors = CardDefaults.cardColors(containerColor = grey),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 0.dp),
                ) {

                    itemsIndexed(exploreList_log) { _, item ->
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickWithColorRipple(black, true) {
                                        onItemSelect.invoke(item.screen)
                                    }
                                    .padding(horizontal = 16.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(item.iconRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(22.dp)
                                        .dropShadow(
                                            shape = RoundedCornerShape(4.dp),
                                            spread = (-4).dp
                                        )
                                )
                                16.dp.toWidth()
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.labelLarge.copy(
                                        fontSize = 13.sp,
                                        color = red
                                    )
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                    tint = red.copy(alpha = 0.5f),
                                    contentDescription = "Next",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }
            20.dp.toheight()
        }
    }


}

@Composable
@Preview
fun ExploreScreenPreview() {
    SMCAndroidTheme {
        ExploreScreen()
    }

}