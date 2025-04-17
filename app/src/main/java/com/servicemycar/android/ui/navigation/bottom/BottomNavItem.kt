package com.servicemycar.android.ui.navigation.bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MiscellaneousServices
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MiscellaneousServices
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.servicemycar.android.R


enum class BottomItemId{
    HOME,
    SERVICES,
    PROFILE
}


sealed class BottomNavItem(
    val id:BottomItemId,
    var title:String,
    var icon:Int,
    var iconUnSelected:Int,
    var animatedIconRes:Int = 0,
) {
    data object Home:BottomNavItem(
        id = BottomItemId.HOME,
        title = "Home",
        icon = R.drawable.img_home_filled,
        iconUnSelected = R.drawable.img_home_outlined,
        animatedIconRes = R.drawable.home_anim
    )

    data object Services:BottomNavItem(
        id = BottomItemId.SERVICES,
        title = "Explore",
        icon = R.drawable.img_explore_filled,
        iconUnSelected = R.drawable.img_explore_outlined,
        animatedIconRes = R.drawable.my_services_anim
    )

    data object Profile:BottomNavItem(
        id = BottomItemId.PROFILE,
        title = "Account",
        icon = R.drawable.img_user_filled,
        iconUnSelected = R.drawable.img_user_outlined,
        animatedIconRes = R.drawable.account_anim
    )

}


val bottomNavList = listOf(
    BottomNavItem.Home,
    BottomNavItem.Services,
    BottomNavItem.Profile,
)