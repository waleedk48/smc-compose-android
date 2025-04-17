package com.servicemycar.android.ui.screens.main.book.components.datetime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple

@Composable
fun DateSlotCard(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = white),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Column(
            modifier = modifier.padding(12.dp)
        ) {


            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Chose Date",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = greyDark,
                        fontSize = 10.sp
                    )
                )
                8.dp.toWidth()
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 0.5.dp,
                    color = greyDark
                )
            }
            5.dp.toheight()
            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .height(53.dp)
                        .width(40.dp)
                        .background(
                            grey,
                            RoundedCornerShape(8.dp)
                        )
                        .padding(12.dp)
                        .clickWithColorRipple(greyDark, true) {

                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = black,
                        contentDescription = "back",
                        modifier = Modifier.size(26.dp)
                    )
                }

                HorizontalPager (
                    modifier = Modifier.weight(1f),
                    pageSize = PageSize.Fixed(
                        pageSize = 55.dp
                    ),
                    state = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f,pageCount = {12})
                ) {
                        ItemDate()

                }

                Column(
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .height(53.dp)
                        .width(40.dp)
                        .background(
                            grey,
                            RoundedCornerShape(8.dp)
                        )
                        .padding(12.dp)
                        .clickWithColorRipple(greyDark, true) {

                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        tint = black,
                        contentDescription = "forward",
                        modifier = Modifier.size(26.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun DateSlotCardPreview() {
    DateSlotCard()
}