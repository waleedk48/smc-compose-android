package com.servicemycar.android.ui.screens.intro

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.white
import org.koin.androidx.compose.koinViewModel

@Composable
fun IntroSliderScreen(
    navController: NavController,
    viewModel: IntroViewModel = koinViewModel()
) {
    viewModel.callMutexTTest()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { 4 }
    )
    val sliderImages = listOf(
        rememberAsyncImagePainter("https://img.freepik.com/free-photo/close-up-hands-unrecognizable-mechanic-doing-car-service-maintenance_146671-19691.jpg?t=st=1729665143~exp=1729668743~hmac=2d30479b2e8ebad3a391b8546c2336e4a7dc6744a2366fdd1af7396b93aa289f&w=1060"),
        rememberAsyncImagePainter("https://img.freepik.com/free-photo/mechanic-showing-customer-problem-with-car_1170-1413.jpg?t=st=1729665199~exp=1729668799~hmac=4f7491d3abb69b69f932a01be02980c93944661c371cc75371d09156da427e5c&w=1060"),
        rememberAsyncImagePainter("https://img.freepik.com/free-photo/mid-adult-mechanic-examining-car-engine-while-using-lamp-auto-repair-shop_637285-4291.jpg?t=st=1729665219~exp=1729668819~hmac=bafa8feac9cb6d0a0a2e880128fdef3a210fec700ab1e5f7218620599e2b7017&w=1060"),
        rememberAsyncImagePainter("https://img.freepik.com/free-photo/muscular-car-service-worker-repairing-vehicle_146671-19694.jpg?t=st=1729665251~exp=1729668851~hmac=4ef97d17484186408f47fe3f57441eb632f98b645dd3f58eaa9af534b3ad3dfd&w=1060")
    )


    Scaffold(
        containerColor = backgroundColor
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            HorizontalPager(
                state = pagerState,
                pageSpacing = 16.dp,
                beyondViewportPageCount = 2,
                modifier = Modifier.fillMaxWidth()
            ) { index ->
                Card(
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 42.dp),
                    colors = CardDefaults.cardColors(containerColor = white),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(300.dp)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        val pageOffset = pagerState.calculateCurrentOffsetForPage(index)
                        Image(
                            painter = sliderImages[index],
                            contentDescription = "",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .fillMaxWidth()
                                .graphicsLayer {
                                    // get a scale value between 1 and 1.75f, 1.75 will be when its resting,
                                    // 1f is the smallest it'll be when not the focused page
                                    val scale = lerp(1f, 1.75f, pageOffset)
                                    // apply the scale equally to both X and Y, to not distort the image
                                    scaleX = scale
                                    scaleY = scale
                                }

                        )
                        32.dp.toheight()
                        Text(
                            "SKIP THE GARAGE",
                            style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp)
                        )
                        5.dp.toheight()
                        Text(
                            "Get all your car maintenance needs at the tap of a button",
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }
            LazyRow(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(4) {
                    5.dp.toWidth()
                    Icon(
                        imageVector = Icons.Default.Circle,
                        contentDescription = "",
                        modifier = Modifier
                            // .size(if (pagerState.currentPage == it) 16.dp else 12.dp)
                            .border(
                                1.dp,
                                color = if (pagerState.currentPage == it) green else greyHint,
                                shape = CircleShape
                            )
                            .size(if (pagerState.currentPage == it) 14.dp else 10.dp)
                            .padding(2.dp),
                        tint = if (pagerState.currentPage == it) green else greyHint
                    )
                    5.dp.toWidth()
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            ElevatedButton(
                onClick = {
                    navController.navigate(NavigationItem.Login)
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 24.dp)
            ) {
                Text(
                    text = "Let's Go",
                    style = MaterialTheme.typography.labelMedium.copy(color = white)
                )
            }
        }
    }
}


@Composable
@Preview
private fun IntroSliderScreenPreview() {
    IntroSliderScreen(navController = NavController(LocalContext.current))
}

// extension method for current page offset
@OptIn(ExperimentalFoundationApi::class)
fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}