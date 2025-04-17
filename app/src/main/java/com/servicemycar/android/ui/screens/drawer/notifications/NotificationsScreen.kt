package com.servicemycar.android.ui.screens.drawer.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.R
import com.servicemycar.android.ui.dialogs.sheets.ShowMyCarsBottomSheet
import com.servicemycar.android.ui.dialogs.sheets.widgets.ShowNotificationDetailsBottomSheet
import com.servicemycar.android.ui.screens.drawer.notifications.items.ItemNotification
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(
    onDrawerStateChange: () -> Unit = {}
) {
    var showDetailBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Notifications",
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

        if (showDetailBottomSheet) ShowNotificationDetailsBottomSheet {
            showDetailBottomSheet = it
        }

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxHeight()
            ) {
                items(2) {
                    Box(modifier = Modifier.padding(vertical = 4.dp)) {
                        ItemNotification(onClick = {
                            showDetailBottomSheet = true
                        })
                    }
                }
            }

        }
    }
}


@Composable
@Preview
private fun NotificationsScreenPreview(
) {
    NotificationsScreen()
}