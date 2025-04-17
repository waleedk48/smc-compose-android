package com.servicemycar.android.ui.screens.main.book.components.datetime

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.greyDark

@Composable
fun ItemDate(modifier: Modifier = Modifier, isSelected:Boolean = false) {
    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .border(width = if (isSelected) 0.8.dp else 0.5.dp, color = if (isSelected) green else greyDark.copy(alpha = 0.4f), shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) green.copy(alpha = 0.1f) else Color.Transparent)
            .padding(horizontal = 6.dp, vertical = 4.dp)
    ) {
        val (date, day, dot) = createRefs()
        Text(
            "11",
            style = MaterialTheme.typography.bodyMedium.copy(color = if (isSelected) green else black),
            modifier = Modifier.constrainAs(date) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }.padding(top = 2.dp))
        Text(
            "Wed",
            style = MaterialTheme.typography.bodyMedium.copy(color = if (isSelected) green else greyDark),
            modifier = Modifier.constrainAs(day) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(date.bottom)
            }.padding(top = 3.dp))
        Icon(
            imageVector = Icons.Default.Circle,
            tint = green,
            contentDescription = null,
            modifier = Modifier
                .size(6.dp)
                .constrainAs(dot) {
                    end.linkTo(parent.end)
                    start.linkTo(date.end)
                    top.linkTo(parent.top)
                })
    }
}

@Composable
@Preview(showBackground = true)
private fun ItemDatePreview() {
    MaterialTheme {
        ItemDate(isSelected = false)
    }

}