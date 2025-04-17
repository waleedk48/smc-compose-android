package com.servicemycar.android.ui.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.white


@Composable
fun DottedHorizontalDivider(
    modifier: Modifier,
    dotColor:Color = greyDark
) {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    Canvas(modifier = modifier) {

        drawLine(
            color = dotColor,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}


@Composable
@Preview(showBackground = true)
private fun DottedHorizontalDividerPreview() {
    DottedHorizontalDivider(modifier = Modifier.fillMaxWidth().height(5.dp))
}