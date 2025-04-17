package com.servicemycar.android.ui.screens.main.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.R
import com.servicemycar.android.models.ServiceModel
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.white
import org.koin.androidx.compose.navigation.koinNavViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceDetailScreen(
    navController: NavController,
    serviceModel: ServiceModel,
) {

    val bullet = "\u2022"

    val messages = listOf(
        "Different grade of oils may be required for your vehicle which will incur an additional cost",
        "Parts included: Genuine oil filter ad 5W30 fully synthetic engine oil",
        "Air filter, AC filter and spark plugs will be cleaned or replaced at an additional cost pre quoted to you for approval before replacement"
    )


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Major Service",
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = black,
                            fontSize = 18.sp,
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }) {
                        Icon(
                            modifier = Modifier
                                .size(26.dp, 30.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(color = black)
                                .padding(horizontal = 6.dp, vertical = 6.dp),
                            imageVector = Icons.Default.ArrowBackIosNew,
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
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column() {
                Card(
                    colors = CardDefaults.cardColors().copy(containerColor = black),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 16.dp)
                    ) {
                        Text(
                            text = "Recommended at every 8-10,000 KM intervals",
                            overflow = TextOverflow.Visible,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = white,
                                fontSize = 16.sp
                            )
                        )
                        12.dp.toheight()
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Now Only AED",
                                style = MaterialTheme.typography.bodySmall.copy(color = white)
                            )
                            15.dp.toWidth()
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(color = white)
                                    .padding(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "499",
                                    style = MaterialTheme.typography.labelLarge.copy(
                                        color = black,
                                        fontSize = 18.sp
                                    )
                                )
                                2.dp.toWidth()
                                Text(
                                    text = "+ vat",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = black,
                                        fontSize = 11.sp
                                    )
                                )
                            }

                        }
                    }
                }
                15.dp.toheight()
                Text(text = "Whats Included...", style = MaterialTheme.typography.labelLarge)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    userScrollEnabled = false,
                    modifier = Modifier.heightIn(max = 300.dp)
                ) {
                    //TODO: replace with real list
                    items((1..8).map { it.toString() }.toList()) {
                        Card(
                            shape = RoundedCornerShape(4.dp),
                            colors = CardDefaults.cardColors().copy(containerColor = white),
                            elevation = CardDefaults.elevatedCardElevation(),
                            modifier = Modifier
                                .padding(horizontal = 6.dp, vertical = 6.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(5.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    painter = painterResource(id = R.drawable.bg_placeholder),
                                    contentDescription = null
                                )
                                Box(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "Collection\nDelievery",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = black,
                                        fontSize = 10.sp
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
                20.dp.toheight()
                Text(text = "More Info...", style = MaterialTheme.typography.labelLarge)
                8.dp.toheight()
                Text(
                    text = buildString {
                        messages.forEach {
                            append(bullet)
                            append("\t")
                            append(it)
                            append("\n")
                        }
                    },
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = black,
                        lineHeight = 16.sp
                    )
                )
                Spacer(modifier = Modifier.weight(1f))

            }
            ElevatedButton(
                onClick = {
                    navController.navigate(NavigationItem.ServiceBook(service = serviceModel))
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.labelMedium.copy(color = white)
                )
            }
        }

    }
}

@Composable
@Preview
private fun ServiceDetailScreenPreview() {
    ServiceDetailScreen(
        navController = NavController(LocalContext.current),
        serviceModel = ServiceModel(id = "", name = "Major Service")
    )
}