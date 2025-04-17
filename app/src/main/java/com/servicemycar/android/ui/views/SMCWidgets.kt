package com.servicemycar.android.ui.views

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.transparent
import com.servicemycar.android.ui.theme.white


@Composable
fun SmcListTile(
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: (() -> Unit) = {},
    showRipple:Boolean = false,
    cardBackgroundColor: Color = white,
    padding:PaddingValues = PaddingValues(),
    contentPadding:PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
    leading: @Composable (() -> Unit)? = null,
    title: @Composable () -> Unit,
    subTitle: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
) {
    Card(
        //onClick = onClick,
       // interactionSource = remember { MutableInteractionSource() },
        modifier = modifier.clickWithColorRipple(transparent, showRipple) {onClick.invoke()},
        colors = CardDefaults.cardColors().copy(containerColor = cardBackgroundColor),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(contentPadding)
                .padding(padding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                leading?.let { it() }
                leading?.let { 8.dp.toWidth() }

                Column(
                    modifier = Modifier.fillMaxHeight().wrapContentHeight(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start
                ) {
                    5.dp.toheight()
                    title()
                    2.dp.toheight()
                    subTitle?.let { it() }
                }
            }
            trailing?.let { it() }
        }
    }
}