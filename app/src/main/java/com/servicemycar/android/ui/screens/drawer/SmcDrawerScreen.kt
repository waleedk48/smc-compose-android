package com.servicemycar.android.ui.screens.drawer

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.screens.drawer.invite.InviteFriendsScreen
import com.servicemycar.android.ui.screens.drawer.mycars.MyCarsScreen
import com.servicemycar.android.ui.screens.drawer.myservices.MyServicesScreen
import com.servicemycar.android.ui.screens.drawer.notifications.NotificationsScreen
import com.servicemycar.android.ui.screens.drawer.support.SupportScreen
import com.servicemycar.android.ui.screens.main.home.HomeScreen
import com.servicemycar.android.ui.screens.main.home.drawer.DrawerBody
import com.servicemycar.android.ui.screens.main.home.drawer.DrawerHeader
import com.servicemycar.android.ui.theme.backgroundColor
import kotlinx.coroutines.launch


enum class DrawerScreens {
    HOME,
    NOTIFICATIONS,
    MY_SERVICES,
    MY_CARS,
    MY_ADDRESSES,
    INVITE_FRIENDS,
    SUPPORT,
    MY_REPAIR_QUOTES,
    MY_ROADSIDE_ASSISTANT,
    MY_SERVICE_CONTRACTS,
    LOGOUT
}


@Composable
fun SmcDrawerScreen(
    navController: NavController
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var currentScreen by remember { mutableStateOf(DrawerScreens.HOME) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.7f)
                    .fillMaxHeight(fraction = .9f)
                    .padding(top = 1.dp),
                drawerShape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp),
                drawerContainerColor = backgroundColor,
            ) {
                12.dp.toheight()
                DrawerHeader(onRewardsClick = {
                    //navController.navigate(NavigationItem.InviteFriends)
                    currentScreen = DrawerScreens.INVITE_FRIENDS
                    scope.launch {
                        drawerState.close()
                    }
                })
                DrawerBody(onItemSelect = {
                    currentScreen = it
                    scope.launch {
                        drawerState.close()
                    }
                })
            }

        }) {
        when (currentScreen) {
            DrawerScreens.HOME -> HomeScreen(navController) {
                scope.launch {
                    drawerState.open()
                }
            }

            DrawerScreens.INVITE_FRIENDS -> InviteFriendsScreen(navController) {
                scope.launch {
                    drawerState.open()
                }
            }

            DrawerScreens.NOTIFICATIONS -> NotificationsScreen {
                scope.launch {
                    drawerState.open()
                }
            }

            DrawerScreens.MY_SERVICES -> MyServicesScreen(navController = navController) {
                scope.launch {
                    drawerState.open()
                }
            }

            DrawerScreens.MY_CARS -> MyCarsScreen(navController = navController) {
                scope.launch {
                    drawerState.open()
                }
            }

            DrawerScreens.MY_ADDRESSES -> {}
            DrawerScreens.SUPPORT -> {
                SupportScreen(navController = navController)
            }

            DrawerScreens.MY_REPAIR_QUOTES -> {}
            DrawerScreens.MY_ROADSIDE_ASSISTANT -> {}
            DrawerScreens.MY_SERVICE_CONTRACTS -> {}
            DrawerScreens.LOGOUT -> {

            }
        }
    }
}


@Composable
@Preview
private fun SmcDrawerScreenPreview() {
    SmcDrawerScreen(navController = NavController(LocalContext.current))
}