package com.servicemycar.android.ui.helpers

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp

@SuppressLint("ComposableNaming")
@Composable
fun Dp.toheight(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.height(this))
}

@SuppressLint("ComposableNaming")
@Composable
fun Dp.toWidth(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.width(this))
}

@Composable
fun Modifier.verticalDragDirection(onDrag: (isDragUp: Boolean) -> Unit): Modifier {
    pointerInput(Unit) {
        detectVerticalDragGestures { _, dragAmount ->
            when {
                dragAmount < 0 -> { // Upward drag (negative y direction)
                    onDrag.invoke(true)
                }

                dragAmount > 0 -> { // Downward drag (positive y direction)
                    onDrag.invoke(false)

                }
            }
        }
    }
    return this
}