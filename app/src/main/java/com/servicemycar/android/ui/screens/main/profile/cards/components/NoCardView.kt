package com.servicemycar.android.ui.screens.main.profile.cards.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.white

@Composable
fun NoCardView(modifier: Modifier = Modifier, onAddCardClick:() -> Unit = {}) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = white),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Image(
                    painter = painterResource(R.drawable.ic_mastercard),
                    contentDescription = "mastercard",
                    modifier = Modifier
                        .size(32.dp, 24.dp)
                        .border(1.dp, grey, RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                )
                15.dp.toWidth()
                Image(
                    painter = painterResource(R.drawable.ic_visa),
                    contentDescription = "visa",
                    modifier = Modifier
                        .size(32.dp, 24.dp)
                        .border(1.dp, grey, RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }
            15.dp.toheight()
            Text(
                "Add your first credit card\nfor payment",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
            15.dp.toheight()
            Text(
                "This credit card will be used by default for billing.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            25.dp.toheight()

            Button(
                onClick = {onAddCardClick.invoke()},
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    "Add new card",
                    style = MaterialTheme.typography.labelSmall.copy(color = white)
                )
            }

        }
    }
}

@Composable
@Preview
private fun NoCardViewPreview() {
    SMCAndroidTheme {
        NoCardView()
    }
}