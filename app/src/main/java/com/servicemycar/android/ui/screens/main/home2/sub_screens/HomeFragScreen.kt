package com.servicemycar.android.ui.screens.main.home2.sub_screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditLocationAlt
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.servicemycar.android.R
import com.servicemycar.android.ui.dialogs.sheets.ShowMyCarsBottomSheet
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.screens.intro.calculateCurrentOffsetForPage
import com.servicemycar.android.ui.screens.main.home2.components.ItemCategory
import com.servicemycar.android.ui.screens.main.home2.data.staticCategories
import com.servicemycar.android.ui.screens.main.home2.data.staticServices
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.bottomBorder
import com.servicemycar.android.ui.views.clickWithColorRipple
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.skydoves.balloon.compose.setBackgroundColor
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeFrgScreen(navController: NavController) {
    val pageScrollState = rememberScrollState()
    var isScrollingUp by remember { mutableStateOf(true) }
    var categorySelected by remember { mutableIntStateOf(0) }
    var showMyCarsBottomSheet by remember { mutableStateOf(false) }

    val builder = rememberBalloonBuilder {
        setArrowSize(8)
        setArrowPosition(0.1f)
        setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
        setWidth(BalloonSizeSpec.WRAP)
        setHeight(BalloonSizeSpec.WRAP)
        setPadding(8)
        setMarginHorizontal(12)
        setCornerRadius(4f)
        setBackgroundColor(green)
        setArrowAlignAnchorPadding(0)
        setBalloonAnimation(BalloonAnimation.CIRCULAR)
    }

    val value by rememberInfiniteTransition(label = "infintemycar").animateFloat(
        initialValue = 0.dp.value,
        targetValue = 0.7.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "infintemycar"
    )


    val sliderImages = listOf(
        rememberAsyncImagePainter("https://img.freepik.com/free-photo/close-up-hands-unrecognizable-mechanic-doing-car-service-maintenance_146671-19691.jpg?t=st=1729665143~exp=1729668743~hmac=2d30479b2e8ebad3a391b8546c2336e4a7dc6744a2366fdd1af7396b93aa289f&w=1060"),
        rememberAsyncImagePainter("https://img.freepik.com/free-photo/mechanic-showing-customer-problem-with-car_1170-1413.jpg?t=st=1729665199~exp=1729668799~hmac=4f7491d3abb69b69f932a01be02980c93944661c371cc75371d09156da427e5c&w=1060"),
        rememberAsyncImagePainter("https://img.freepik.com/free-photo/mid-adult-mechanic-examining-car-engine-while-using-lamp-auto-repair-shop_637285-4291.jpg?t=st=1729665219~exp=1729668819~hmac=bafa8feac9cb6d0a0a2e880128fdef3a210fec700ab1e5f7218620599e2b7017&w=1060"),
        rememberAsyncImagePainter("https://img.freepik.com/free-photo/muscular-car-service-worker-repairing-vehicle_146671-19694.jpg?t=st=1729665251~exp=1729668851~hmac=4ef97d17484186408f47fe3f57441eb632f98b645dd3f58eaa9af534b3ad3dfd&w=1060")
    )

    val pagerState = rememberPagerState(
        initialPage = 1,
        initialPageOffsetFraction = 0.3f,
        pageCount = { Int.MAX_VALUE }
    )

    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    if (!isDragged)
        LaunchedEffect(Unit) {
            repeat(times = Int.MAX_VALUE, action = {
                delay(timeMillis = 5000)
                pagerState.animateScrollToPage(
                    page = pagerState.currentPage + 1
                )
            })
        }
    Scaffold(
        containerColor = backgroundColor,
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavigationItem.Support)
                },
                containerColor = black,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.size(45.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.img_customer_support),
                    tint = white,
                    contentDescription = "help",
                    modifier = Modifier.size(22.dp)
                )
            }
        },
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundColor),
                modifier = Modifier
                    .bottomBorder(1.dp, black.copy(alpha = 0.2f)),
                title = {
                    Column {
                        Text("Hi, Santosh!", style = MaterialTheme.typography.labelSmall)
                        Text("Good Morning", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold))
                    }
                },
                actions = {
//                    Icon(
//                        modifier = Modifier.clickWithColorRipple(green, true) {
//                        },
//                        imageVector = Icons.Default.SupportAgent,
//                        tint = black,
//                        contentDescription = "support"
//                    )
//                    12.dp.toWidth()
                    BadgedBox(
                        modifier = Modifier.padding(end = 12.dp),
                        badge = {
                            Badge(
                                containerColor = green
                            ) {
                                Text(
                                    "3",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        color = white,
                                        fontSize = 8.sp
                                    )
                                )
                            }
                        }) {
                        Icon(
                            modifier = Modifier.clickWithColorRipple(green, true) {
                            }.size(24.dp),
                            painter = painterResource(R.drawable.img_bell_notification),
                            tint = black,
                            contentDescription = "notifications"
                        )
                    }


                }
            )
        },
    ) { paddingValues ->

        if (showMyCarsBottomSheet) ShowMyCarsBottomSheet {
            showMyCarsBottomSheet = it
        }

        Column(modifier = Modifier.padding(paddingValues)
            .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
            .fillMaxSize()
            .verticalScroll(pageScrollState)
//            .verticalDragDirection { isUp ->
//            isScrollingUp = isUp
//            }
            .pointerInput(Unit) {
                detectVerticalDragGestures { _, dragAmount ->
                    when {
                        dragAmount < 0 -> { // Upward drag (negative y direction)
                            isScrollingUp = false
                        }

                        dragAmount > 0 -> { // Downward drag (positive y direction)
                            isScrollingUp = true
                        }
                    }
                }
            }
        ) {
            HorizontalDivider(color = black.copy(alpha = 0.05f))
            LazyRow(
                modifier = Modifier.padding(top = 12.dp, start = 2.dp, end = 2.dp)
            ) {
                items(staticCategories.size) { index ->
                    ItemCategory(
                        category = staticCategories[index],
                        isSelected = categorySelected == index,
                        showIcons = isScrollingUp,
                        onSelect = {
                            categorySelected = index
                        })
                }

            }
            12.dp.toheight()

            Balloon(modifier = Modifier,
                builder = builder,
                balloonContent = {
                    Text(
                        text = "Your selected car, please click on arrow to select different one",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 10.sp,
                            color = white
                        )
                    )
                }
            ) { balloonWindow ->
                Card(
                    onClick = {
                        builder.arrowPosition = 0.1f
                        balloonWindow.showAlignBottom()
                    },
                    colors = CardDefaults.cardColors(containerColor = grey),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(0.dp),
                    modifier = Modifier.shadow(
                        1.dp,
                        shape = RoundedCornerShape(8.dp),
                        ambientColor = black.copy(alpha = 0.03f),
                        spotColor = black.copy(alpha = 0.05f)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.logo_mercedies),
                            contentDescription = "car logo",
                            modifier = Modifier.size(26.dp)
                        )
                        8.dp.toWidth()
                        Text(
                            "Mercedes Benz E-Class",
                            style = MaterialTheme.typography.labelMedium.copy(fontSize = 13.sp, fontWeight = FontWeight.SemiBold),
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            tint = black,
                            contentDescription = null,
                            modifier = Modifier
                                .size(22.dp)
                                .clickWithColorRipple(green, true) {
                                        showMyCarsBottomSheet = true
                                }
                        )
                    }
                }
            }
            Balloon(modifier = Modifier,
                builder = builder,
                balloonContent = {
                    Text(
                        text = "Your current location, which will be used for pickups and deliveries of your vehicles by default.",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 10.sp,
                            color = white
                        )
                    )
                }
            ) { balloonWindow ->
                Card(
                    onClick = {
                        builder.arrowPosition = 0.1f
                        balloonWindow.showAlignBottom()
                    },
                    colors = CardDefaults.cardColors(containerColor = grey),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(0.dp),
                    modifier = Modifier.shadow(
                        1.dp,
                        shape = RoundedCornerShape(8.dp),
                        ambientColor = black.copy(alpha = 0.03f),
                        spotColor = black.copy(alpha = 0.05f)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.MyLocation,
                            contentDescription = "User logo",
                            tint = black,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(22.dp)
                        )
                        8.dp.toWidth()
                        Text(
                            "Al Qouz Indus-Area 4, Dubai UAE",
                            style = MaterialTheme.typography.labelMedium.copy(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Default.EditLocationAlt,
                            tint = black,
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                                .clickWithColorRipple(green, true) {

                                }
                        )
                    }
                }
            }
            15.dp.toheight()
            HorizontalPager(
                state = pagerState,
                pageSpacing = (-8).dp,
                beyondViewportPageCount = 3,
                contentPadding = PaddingValues(horizontal = 60.dp),
                modifier = Modifier.fillMaxWidth()
            ) { i ->
                val pageOffset = (pagerState.currentPage - i) + pagerState.currentPageOffsetFraction
                val scale = if (pageOffset == 0f) {
                    1f // Center page, no scaling
                } else {
                    1f - 0.15f * Math.abs(pageOffset) // Scale down as it moves away from the center
                }

                val index = i % sliderImages.size
                Card(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            alpha = 1f - 0.2f * Math.abs(pageOffset) // Make off-center pages slightly transparent
                        ),
                    colors = CardDefaults.cardColors(containerColor = grey),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(0.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 120.dp, max = 120.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        val pageOffset = pagerState.calculateCurrentOffsetForPage(index)
                        Image(
                            painter = sliderImages[index],
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth()
                        )
                    }
                }

            }
            15.dp.toheight()
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier.heightIn(max = 500.dp)
            ) {
                //TODO: replace with real list
                items(staticServices) { service ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors().copy(containerColor = grey),
                        elevation = CardDefaults.elevatedCardElevation(0.dp),
                        modifier = Modifier
                            .padding(horizontal = 6.dp, vertical = 6.dp)
                            .clickWithColorRipple(black, true) {

                                navController.navigate(
                                    NavigationItem.ServiceDetail(
                                        service = service
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
                                    .data(service.imgUrl)
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
                                text = service.name.replace(" ", "\n"),
                                style = MaterialTheme.typography.bodyMedium.copy(color = black, fontWeight = FontWeight.Bold, fontSize = 12.sp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }

}

@Composable
@Preview
fun HomeFrgScreenPreview() {
    HomeFrgScreen(navController = NavController(LocalContext.current))
}