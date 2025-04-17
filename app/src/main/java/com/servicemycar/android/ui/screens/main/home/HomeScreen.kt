package com.servicemycar.android.ui.screens.main.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.servicemycar.android.R
import com.servicemycar.android.models.ServiceModel
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.screens.main.home.composes.FreebiaseCard
import com.servicemycar.android.ui.screens.main.home.composes.HomeAppBar
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple


@Composable
fun HomeScreen(
    navController: NavController,
    onDrawerStateChange: () -> Unit = {},
) {
    Scaffold(
        containerColor = backgroundColor,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HomeAppBar {
                onDrawerStateChange.invoke()
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Popular Services",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = black
                )
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier.heightIn(max = 500.dp)
            ) {
                //TODO: replace with real list
                items((1..13).map { it.toString() }.toList()) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        colors = CardDefaults.cardColors().copy(containerColor = white),
                        elevation = CardDefaults.elevatedCardElevation(),
                        modifier = Modifier
                            .padding(horizontal = 6.dp, vertical = 6.dp)
                            .clickWithColorRipple(black, true) {

                                navController.navigate(
                                    NavigationItem.ServiceDetail(
                                        service = ServiceModel(
                                            id = "123",
                                            "Major Service"
                                        )
                                    )
                                )
                                //TODO: replace with real model
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data("https://iconurl.com/icon.png")
                                    .build(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                placeholder = painterResource(id = R.drawable.bg_placeholder),
                                error = painterResource(id = R.drawable.bg_placeholder),
                                contentDescription = null
                            )
                            Box(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Major Service",
                                style = MaterialTheme.typography.bodyMedium.copy(color = black),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
            16.dp.toheight()
            FreebiaseCard(progress = 3, maxProgress = 5)
            25.dp.toheight()


        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(NavController(LocalContext.current))
}