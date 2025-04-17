package com.servicemycar.android.ui.screens.main.profile.cards.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple

@Composable
fun PaymentCardItem(modifier: Modifier = Modifier, isDefault: Boolean = false, onDeleteClick:() -> Unit = {}) {
    Card(
        colors = CardDefaults.cardColors(containerColor = white),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_visa),
                contentDescription = "mastercard",
                modifier = Modifier
                    .size(58.dp, 34.dp)
                    .border(1.dp, grey, RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
            8.dp.toWidth()
            Column {
                Text(
                    "Visa ending in 7860",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    "Exp. date 02/25",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp)
                )

            }
            5.dp.toWidth(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    if (isDefault) "Default" else "Set Default",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 12.sp,
                        color = if (isDefault) white else green
                    ),
                    modifier = Modifier.background(if (isDefault) black else Color.Transparent, shape = RoundedCornerShape(4.dp)).padding(if (isDefault) 3.dp else 0.dp)
                )
                8.dp.toWidth()
                Icon(
                    painter = painterResource(R.drawable.ic_trash_outlined),
                    tint = red,
                    contentDescription = "delete",
                    modifier = Modifier.size(20.dp).clickWithColorRipple(red,true){
                        onDeleteClick.invoke()
                    }
                )
            }
        }
    }
}

@Composable
@Preview
private fun PaymentCardItemPreview() {
    SMCAndroidTheme {
        PaymentCardItem()
    }
}