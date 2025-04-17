package com.servicemycar.android.ui.screens.drawer.myservices

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.screens.drawer.myservices.items.ItemService
import com.servicemycar.android.ui.screens.drawer.myservices.items.ItemService2
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyServicesScreen(navController: NavController, onDrawerStateChange: () -> Unit = {}) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Current", "Past")
    val pagerState = rememberPagerState { tabs.size }
    val scope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.distinctUntilChanged().collect {
            tabIndex = it
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
              //  windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "My Services",
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 19.sp, color = black)
                    )
                },
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
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
        ) {
            TabRow(
                selectedTabIndex = tabIndex,
                containerColor = backgroundColor,
                modifier = Modifier.border(1.dp, black, RoundedCornerShape(8.dp)).padding(4.dp).heightIn(max = 30.dp),
                indicator = { tabPositions ->
                    Row(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]).zIndex(-1f),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .background(color = black, shape = RoundedCornerShape(8.dp))
                        )
                    }
                },
                divider = { 0.0.dp.toWidth() }
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = {
                            tabIndex = index
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }

                        },
//                        modifier = Modifier.background(
//                            if (tabIndex == index) black else backgroundColor,
//                            shape = RoundedCornerShape(8.dp)
//                        )
                    ) {
                        Row(
                            modifier = Modifier.wrapContentWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                if (index == 0) "2" else "8",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (tabIndex == index) black else white
                                ),
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(2.dp)
                                    .drawBehind {
                                        drawCircle(
                                            color = if (tabIndex == index) white else black,
                                            radius = 20f
                                        )
                                    },
                            )
                            8.dp.toWidth()
                            Text(
                                title,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (tabIndex == index) white else black
                                ),
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }
                }
            }
            HorizontalPager(state = pagerState, pageSize = PageSize.Fill, pageSpacing = 12.dp) {
                LazyColumn {
                    items(if (tabIndex == 0) 2 else 8) {
                        ItemService2(isHistory = tabIndex>0)
                    }
                }
            }
        }
    }


}


@Composable
@Preview(showBackground = true)

private fun MyServicesScreenPreview() {
    SMCAndroidTheme {
        MyServicesScreen(NavController(LocalContext.current))
    }

}