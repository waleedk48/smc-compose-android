package com.servicemycar.android.ui.dialogs.sheets.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirportShuttle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.R
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.SmcListTile


@Composable
fun MyAddressItemView(onAddressSelect:() -> Unit) {
    SmcListTile(
        showRipple = true,
        onClick = onAddressSelect,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp),
        cardBackgroundColor = grey,
        leading = {
            Icon(
                modifier = Modifier
                    .size(32.dp, 32.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .padding(horizontal = 6.dp, vertical = 6.dp),
                imageVector = Icons.Default.Home,
                tint = black,
                contentDescription = null
            )
        },
        title = {
            Text(
                "Address 1",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        },
        subTitle = {
            Text(
                "1402 SMC - Al moosa tower 2, Al satwa, dubai united arab emirates",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp
                )
            )
        },
    )
}


@Composable
@Preview(showBackground = false)
private fun MyAddressItemPreview() {
    Box(modifier = Modifier.height(80.dp)){
        MyAddressItemView{}
    }

}