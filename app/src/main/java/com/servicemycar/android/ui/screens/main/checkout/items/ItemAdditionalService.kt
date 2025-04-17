package com.servicemycar.android.ui.screens.main.checkout.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple


@Composable
fun ItemAdditionalService(
    isSelected: Boolean = false,
    onItemSelect: () -> Unit = {},
    onMoreInfoClick: () -> Unit = {}
) {
    Box(modifier = Modifier.padding(4.dp)) {
        Card(
            modifier = Modifier
                .height(120.dp)
                .wrapContentWidth(),
            colors = CardDefaults.cardColors(containerColor = if (isSelected) black else white),
            shape = RoundedCornerShape(4.dp),
            onClick = onItemSelect
        ) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "RTA\nRenewal",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 14.sp,
                        color = if (isSelected) white else black
                    ),
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    minLines = 2,
                    overflow = TextOverflow.Clip
                )
                8.dp.toheight()
                Text(
                    "300.0 AED",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 10.sp,
                        color = greyHint
                    )
                )
                4.dp.toheight()
                Text(
                    "More Info",
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .fillMaxWidth()
                        .clickWithColorRipple(black, true) {
                            onMoreInfoClick.invoke()
                        },
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 12.sp,
                        color = if (isSelected) white else black
                    ), textAlign = TextAlign.Center, maxLines = 1, overflow = TextOverflow.Ellipsis
                )
                2.dp.toheight()
                HorizontalDivider(color = if (isSelected) grey else black)
            }
        }
    }
}


@Composable
@Preview(showBackground = false)
private fun ItemAdditionalServicePreview() {
    ItemAdditionalService()
}