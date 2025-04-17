package com.servicemycar.android.test.chart.core

import java.text.NumberFormat

data class ValueLabel(
    val value: Float,
    val unit: String
) {
    fun formatted(): String {
        val formatted = NumberFormat.getInstance().apply {
            val fractionDigits = when {
                value > 1000 -> 0
                value in 2f..999f -> 2
                else -> 3
            }
        }
        return "${formatted.format(value)}$unit"
    }
}
