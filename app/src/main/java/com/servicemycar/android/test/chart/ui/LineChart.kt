package com.servicemycar.android.test.chart.ui

import android.annotation.SuppressLint
import androidx.collection.mutableIntSetOf
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.test.chart.core.ChartStyle
import com.servicemycar.android.test.chart.core.DataPoint
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Composable
fun LineChart(
    dataPoints: List<DataPoint>,
    style: ChartStyle,
    visibleDataPointsIndices: IntRange,
    selectedDataPoint: DataPoint? = null,
    onSelectedDataPoint: (DataPoint) -> Unit = {},
    onXLabelWidthChange: (Float) -> Unit = {},
    showHelperLines: Boolean = true,
    modifier: Modifier = Modifier,
    unit: String,
) {
    val textStyle = LocalTextStyle.current.copy(fontSize = style.labelFontSize)

    val visibleDataPoints = remember(dataPoints, visibleDataPointsIndices) {
        dataPoints.slice(visibleDataPointsIndices)
    }

    val maxYValue = remember(visibleDataPoints) { visibleDataPoints.maxOfOrNull { it.y } ?: 0f }
    val minYValue = remember(visibleDataPoints) { visibleDataPoints.minOfOrNull { it.y } ?: 0f }

    val measure = rememberTextMeasurer()

    var xLabelWidth by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(key1 = xLabelWidth) {
        onXLabelWidthChange(xLabelWidth)
    }

    val selectedDataPointIndex = remember { visibleDataPoints.indexOf(selectedDataPoint) }

    var drawPoints by remember { mutableStateOf(listOf<DataPoint>()) }


    Canvas(modifier = modifier.fillMaxWidth()) {

        // convert all padding, spacing and other units in style from dp to pixel
        val minLabelSpacingYPx = style.minYLabelSpacing.toPx()
        val verticalPaddingPx = style.verticalPadding.toPx()
        val horizontalPaddingPx = style.horizontalPadding.toPx()
        // spacing of x Axis label from above chart(viewport) view
        val xAxisLabelsSpacingPx = style.xAxisLabelSpacing.toPx()

        val xLabelLayoutResults = visibleDataPoints.map {
            measure.measure(
                text = it.xLabel,
                style = textStyle.copy(textAlign = TextAlign.Center)
            )
        }

        val maxLabelWidth = xLabelLayoutResults.maxOfOrNull { it.size.width } ?: 0
        val maxLabelHeight = xLabelLayoutResults.maxOfOrNull { it.size.height } ?: 0
        val maxXLabelLineCount = xLabelLayoutResults.maxOfOrNull { it.lineCount } ?: 0

        // the label to show on the top of chart view for selected index
        val xLabelLineHeight =  maxLabelHeight / maxXLabelLineCount

        // the actual graph view.. must be above the x labels and right of y labels
        // 2 x verticalPaddingPx for including equal padding from top and bottom
        val viewPortHeightPx =
            size.height - (maxLabelHeight + (2 * verticalPaddingPx) + xLabelLineHeight + xAxisLabelsSpacingPx)

        val viewPortTopY = verticalPaddingPx + xLabelLineHeight + 10f
        val viewPortBottomY = viewPortTopY + viewPortHeightPx
        val viewPortRightX = size.width
        val viewPortLeftX = 2f * horizontalPaddingPx

        val viewPort = Rect(
            left = viewPortLeftX,
            right = viewPortRightX,
            top = viewPortTopY,
            bottom = viewPortBottomY
        )

        drawRect(
            color = Color.Green,
            topLeft = viewPort.topLeft,
            size = viewPort.size
        )

        xLabelWidth = maxLabelWidth + xAxisLabelsSpacingPx
        xLabelLayoutResults.forEachIndexed { index, result ->
            // x position for each label on x Axis start from the most left of view port, add spacing/2 to equal share
            //between left and right then add width and multiply index to generate on a axis
            val x = viewPortLeftX + xAxisLabelsSpacingPx / 2 + xLabelWidth * index

            drawText(
                result,
                topLeft = Offset(
                    x = x,
                    y = viewPortBottomY + xAxisLabelsSpacingPx
                ),
                color = if (selectedDataPointIndex == index)
                    style.selectedColor
                else
                    style.unselectedColor
            )
        }


        // Y Axis Labels
        // chart view height plus the top selected label height
        val labelViewPortHeightPx = viewPortHeightPx + xLabelLineHeight
        //val labelCountExcludingLastLabel =

    }


}


data class CoinPrice(
    val priceUsd: Double,
    val dateTime: ZonedDateTime,
)


@SuppressLint("NewApi")
@Preview(widthDp = 1000)
@Composable
private fun LineChartPreview() {
    MaterialTheme {
        val coinHistoryRandomized = remember {
            (1..20).map {
                CoinPrice(
                    priceUsd = Random.nextFloat() * 1000.0,
                    dateTime = ZonedDateTime.now().plusHours(it.toLong())
                )
            }
        }
        val style = ChartStyle(
            chartLineColor = Color.Black,
            unselectedColor = Color(0xFF7C7C7C),
            selectedColor = Color.Black,
            helperLinesThicknessPx = 1f,
            axisLinesThicknessPx = 5f,
            labelFontSize = 14.sp,
            minYLabelSpacing = 25.dp,
            verticalPadding = 8.dp,
            horizontalPadding = 8.dp,
            xAxisLabelSpacing = 8.dp
        )
        val dataPoints = remember {
            coinHistoryRandomized.map {
                DataPoint(
                    x = it.dateTime.hour.toFloat(),
                    y = it.priceUsd.toFloat(),
                    xLabel = DateTimeFormatter
                        .ofPattern("ha\nM/d")
                        .format(it.dateTime)
                )
            }
        }
        LineChart(
            dataPoints = dataPoints,
            style = style,
            visibleDataPointsIndices = 0..19,
            unit = "$",
            modifier = Modifier
                .width(700.dp)
                .height(300.dp)
                .background(Color.White),
            selectedDataPoint = dataPoints[1]
        )
    }
}