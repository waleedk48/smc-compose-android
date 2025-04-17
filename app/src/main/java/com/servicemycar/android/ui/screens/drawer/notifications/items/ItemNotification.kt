package com.servicemycar.android.ui.screens.drawer.notifications.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.views.SmcListTile

@Composable
fun ItemNotification(onClick:() -> Unit) {
    SmcListTile(
        onClick = onClick,
        title = {
            Text("HAPPY DIWALI FROM SERVICE MY CAR", style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
        },
        subTitle = {
            Column {
                Text(
                    "This Diwali keep your cars spark alive!",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    "11/11/2024",
                    style = MaterialTheme.typography.bodySmall.copy(color = greyHint, fontSize = 11.sp)
                )
            }
        },
        trailing = {
            IconButton(onClick = onClick) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = "", tint = black, modifier = Modifier.size(18.dp))
            }
        },
        contentPadding = PaddingValues(start = 12.dp, top = 4.dp, bottom = 4.dp)
    )
}

@Composable
@Preview
private fun ItemNotificationPreview() {
    Box(modifier = Modifier.height(80.dp)) {
        ItemNotification{}
    }

}