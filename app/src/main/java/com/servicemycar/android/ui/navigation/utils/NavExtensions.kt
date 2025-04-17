package com.servicemycar.android.ui.navigation.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.bottom.BottomNavItem
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.greyHint

@Composable
fun RowScope.AddItem(
    modifier: Modifier = Modifier,
    screen: BottomNavItem,
    isSelected: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = onClick,
        icon = {
                Icon(
                    painter = painterResource( if (isSelected) screen.icon else screen.iconUnSelected),
                    tint = if (isSelected) green else greyDark,
                    contentDescription = screen.title
                )
        },
        modifier = modifier.padding(top = 0.dp),
        enabled = enabled,
        label = {
            Text(
                screen.title,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontSize = 11.sp,
                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                    color = if (isSelected) green else greyDark
                )
            )
        },
        alwaysShowLabel = true,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Transparent,
            selectedIconColor = green,
            selectedTextColor = black,
            unselectedIconColor = greyDark,
            unselectedTextColor = greyHint
        ),
    )
}