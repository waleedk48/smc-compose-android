package com.servicemycar.android.ui.screens.main.home.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.automirrored.filled.ContactSupport
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.DriveEta
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.servicemycar.android.R
import com.servicemycar.android.ui.screens.drawer.DrawerScreens

data class DrawerMenuItem(
    val id: String,
    val title: String,
    val screen: DrawerScreens,
    val icon: ImageVector,
    val iconRes:Int = 0,
)


val menuList = listOf(
    DrawerMenuItem(
        id = "1",
        title = "Home",
        screen = DrawerScreens.HOME,
        icon = Icons.Default.Home
    ),
    DrawerMenuItem(
        id = "2",
        title = "Notifications",
        screen = DrawerScreens.NOTIFICATIONS,
        icon = Icons.Default.Notifications
    ),
    DrawerMenuItem(
        id = "3",
        title = "My Services",
        screen = DrawerScreens.MY_SERVICES,
        icon = Icons.AutoMirrored.Filled.Assignment
    ),
    DrawerMenuItem(
        id = "4",
        title = "My Cars",
        screen = DrawerScreens.MY_CARS,
        icon = Icons.Default.DriveEta
    ),
    DrawerMenuItem(
        id = "5",
        title = "My Addresses",
        screen = DrawerScreens.MY_ADDRESSES,
        icon = Icons.Default.LocationOn
    ),
    DrawerMenuItem(
        id = "6",
        title = "Invite Friends",
        screen = DrawerScreens.INVITE_FRIENDS,
        icon = Icons.Default.Group
    ),
    DrawerMenuItem(
        id = "7",
        title = "Support",
        screen = DrawerScreens.SUPPORT,
        icon = Icons.AutoMirrored.Filled.ContactSupport
    ),
    DrawerMenuItem(
        id = "8",
        title = "My Repair Quotes",
        screen = DrawerScreens.MY_REPAIR_QUOTES,
        icon = Icons.AutoMirrored.Filled.Message
    ),
    DrawerMenuItem(
        id = "9",
        title = "My Roadside Assistance",
        screen = DrawerScreens.MY_ROADSIDE_ASSISTANT,
        icon = Icons.Default.Construction
    ),
    DrawerMenuItem(
        id = "10",
        title = "My Service Contracts",
        screen = DrawerScreens.MY_SERVICE_CONTRACTS,
        icon = Icons.Default.Description
    ),
    DrawerMenuItem(
        id = "11",
        title = "Logout",
        screen = DrawerScreens.LOGOUT,
        icon = Icons.AutoMirrored.Filled.Logout
    ),
)


//explore screen content
//My Essentials
val exploreList_My = listOf(
    DrawerMenuItem(
        id = "4",
        title = "My Cars",
        screen = DrawerScreens.MY_CARS,
        icon = Icons.Default.DriveEta,
        iconRes = R.drawable.ic_car_3d
    ),
    DrawerMenuItem(
        id = "5",
        title = "My Addresses",
        screen = DrawerScreens.MY_ADDRESSES,
        icon = Icons.Default.LocationOn,
        iconRes = R.drawable.ic_location_3d
    ),
)

//my services
val exploreList_Orders = listOf(
    DrawerMenuItem(
        id = "3",
        title = "My Services",
        screen = DrawerScreens.MY_SERVICES,
        icon = Icons.AutoMirrored.Filled.Assignment,
        iconRes = R.drawable.ic_services_3d
    ),
    DrawerMenuItem(
        id = "8",
        title = "My Repair Quotes",
        screen = DrawerScreens.MY_REPAIR_QUOTES,
        icon = Icons.AutoMirrored.Filled.Message,
        iconRes = R.drawable.ic_repairs_3d
    ),
    DrawerMenuItem(
        id = "9",
        title = "My Roadside Assistance",
        screen = DrawerScreens.MY_ROADSIDE_ASSISTANT,
        icon = Icons.Default.Construction,
        iconRes = R.drawable.ic_truck_roadside_3d

    ),
    DrawerMenuItem(
        id = "10",
        title = "My Service Contracts",
        screen = DrawerScreens.MY_SERVICE_CONTRACTS,
        icon = Icons.Default.Description,
        iconRes = R.drawable.ic_contracts_3d
    ),
)

// support and earn
val exploreList_Support = listOf(
    DrawerMenuItem(
        id = "6",
        title = "Invite Friends",
        screen = DrawerScreens.INVITE_FRIENDS,
        icon = Icons.Default.Group,
        iconRes = R.drawable.ic_invite_friend_3d
    ),
    DrawerMenuItem(
        id = "7",
        title = "Support",
        screen = DrawerScreens.SUPPORT,
        icon = Icons.AutoMirrored.Filled.ContactSupport,
        iconRes = R.drawable.ic_support_3d
    ),
)

val exploreList_log = listOf(
    DrawerMenuItem(
        id = "11",
        title = "Logout",
        screen = DrawerScreens.LOGOUT,
        icon = Icons.AutoMirrored.Filled.Logout,
        iconRes = R.drawable.ic_signout_3d
    ),
)