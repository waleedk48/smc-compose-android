package com.servicemycar.android.ui.screens.main.home.drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.screens.drawer.DrawerScreens
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple

@Composable
@Preview(showBackground = true)
fun DrawerHeader(onRewardsClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(fraction = 0.65f),
                text = "Muhammad Waleed",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    color = black
                )
            )
            16.dp.toWidth()
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Edit, contentDescription = "Edit Profile", tint = black
            )
        }
        5.dp.toheight()
        Text(
            text = "+971 529447229",
            style = MaterialTheme.typography.bodyMedium.copy(color = black)
        )
        15.dp.toheight()
        Card(
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors().copy(containerColor = black),
            onClick = onRewardsClick
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBalanceWallet,
                        contentDescription = null,
                        tint = white
                    )
                    12.dp.toWidth()
                    Text(
                        text = "Reward: 0.00 AED",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 14.sp,
                            color = white
                        )
                    )
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = white
                )
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun DrawerBody(onItemSelect:( item: DrawerScreens) -> Unit = {}) {
    LazyColumn {
        items(menuList) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickWithColorRipple(black,true){
                        onItemSelect.invoke(item.screen)
                    }.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = item.icon, contentDescription = null, tint = greyDark)
                16.dp.toWidth()
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 14.sp,
                        color = black
                    )
                )

            }
        }
    }
}