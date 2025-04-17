package com.servicemycar.android.ui.screens.main.home2.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.bottom.BottomItemId
import com.servicemycar.android.ui.navigation.bottom.bottomNavList
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white

@SuppressLint("NewApi")
@Composable
fun BottomTabBar(
    modifier: Modifier = Modifier,
    onItemSelect: (index: Int, id: BottomItemId) -> Unit = { _, _ -> }
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier
            .height(58.dp)
            .background(white, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
//            .graphicsLayer {
//                renderEffect = android.graphics.RenderEffect.createBlurEffect(25f,25f, Shader.TileMode.MIRROR).asComposeRenderEffect()
//            }
        ,
        containerColor = white,
        indicator = { tabPositions ->

            Row(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .offset(y = (-48).dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .height(3.dp)
                        .width(50.dp)
                        .background(color = black, shape = RoundedCornerShape(2.dp))
                )
            }
        },
        divider = { 1.5.dp.toWidth() }
    ) {
        bottomNavList.forEachIndexed { index, item ->

            Tab(
                modifier = Modifier.height(46.dp),
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    onItemSelect.invoke(index, item.id)
                },
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter =  painterResource(  if (selectedTabIndex == index)item.icon else item.iconUnSelected),
                        modifier = Modifier.size(22.dp),
                        tint = if (selectedTabIndex == index) black else black.copy(alpha = 0.3f),
                        contentDescription = ""
                    )
//                    GifImage(
//                        resId = item.animatedIconRes,
//                        modifier = Modifier.size(24.dp)
//                    )
                    3.dp.toheight()
                    Text(
                        item.title,
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = if (selectedTabIndex == index) black else black.copy(alpha = 0.3f),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun BottomTabBarPreview() {
    MaterialTheme {
        BottomTabBar()
    }
}