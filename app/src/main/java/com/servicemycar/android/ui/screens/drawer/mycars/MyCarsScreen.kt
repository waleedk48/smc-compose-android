package com.servicemycar.android.ui.screens.drawer.mycars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.R
import com.servicemycar.android.ui.dialogs.sheets.widgets.MyCarItemView
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.screens.drawer.mycars.items.ItemCarExpandable
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCarsScreen(navController: NavController, onDrawerStateChange: () -> Unit = {}) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "My Cars",
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
                actions = {

                    Text("Add Car",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = white,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                            .background(black, RoundedCornerShape(4.dp))
                            .padding(PaddingValues(horizontal = 12.dp, vertical = 6.dp))
                            .clickWithColorRipple(white, false) {

                            }
                    )
                    12.dp.toWidth()
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
        LazyColumn (
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
        ) {
            items(12){
                ItemCarExpandable()
            }
        }
    }
}


@Composable
@Preview
private fun MyCarsScreenPreview() {
    MyCarsScreen(NavController(LocalContext.current))
}