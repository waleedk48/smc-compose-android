package com.servicemycar.android.ui.screens.main.home2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.screens.drawer.DrawerScreens
import com.servicemycar.android.ui.screens.main.home2.components.BottomTabBar
import com.servicemycar.android.ui.screens.main.home2.sub_screens.AccountScreen
import com.servicemycar.android.ui.screens.main.home2.sub_screens.ExploreScreen
import com.servicemycar.android.ui.screens.main.home2.sub_screens.HomeFrgScreen
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.white
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.skydoves.balloon.compose.setBackgroundColor

@Composable
fun HomeScreen2(modifier: Modifier = Modifier, navController: NavController) {


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
    var bottomNavSelected by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        bottomBar = {
            Balloon(builder = builder,
                balloonContent = {
                    Text(
                        text = "Please login first to get access to these options. thanks!",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 10.sp,
                            color = white
                        )
                    )
                }
            ) { _ ->

                BottomTabBar(onItemSelect = { index, id ->
                    bottomNavSelected = index
//                                    if (item.id != BottomItemId.HOME) {
//                                        if (item.id == BottomItemId.SERVICES)
//                                            builder.arrowPosition = 0.5f
//                                        else builder.arrowPosition = 0.85f
//                                        balloonWindow.dismiss()
//                                        balloonWindow.showAlignTop()
//                                    } else {
//                                        bottomNavSelected = index
//                                    }
                })
            }

        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())) {
            when (bottomNavSelected) {
                0 -> HomeFrgScreen(navController = navController)
                1 -> ExploreScreen() { screen -> navigateToScreen(screen, navController) }
                else -> AccountScreen(navController)
            }
        }
    }
}


fun navigateToScreen(screen: DrawerScreens, navController: NavController) {
    when (screen) {
        DrawerScreens.MY_SERVICES -> navController.navigate(NavigationItem.MyServices)
        else -> {

        }
    }
}

@Composable
@Preview
private fun HomeScreen2Preview(modifier: Modifier = Modifier) {
    SMCAndroidTheme {
        HomeScreen2(navController = NavController(LocalContext.current))
    }

}


