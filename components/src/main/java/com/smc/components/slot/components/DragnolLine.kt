package com.smc.components.slot.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DiagonalLine() {
    Canvas(modifier = Modifier.fillMaxWidth().height(15.dp)) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // drawing a line between start(x,y) and end(x,y)
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = 25.dp.toPx()),
            color = Color.Red,
            strokeWidth = 5F
        )
    }
}