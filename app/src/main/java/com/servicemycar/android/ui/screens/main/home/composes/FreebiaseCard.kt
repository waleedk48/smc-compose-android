package com.servicemycar.android.ui.screens.main.home.composes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.ProgressStepperView
import org.w3c.dom.Text


class ProgressProvider : PreviewParameterProvider<Int> {
    override val values: Sequence<Int>
        get() = listOf(3).asSequence()
}


@Composable
fun FreebiaseCard(progress: Int, maxProgress: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors().copy(containerColor = white),

        ) {
        Box(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 12.dp)
        ) {
            Column {
                Text(
                    text = "FREE MAJOR SERVICE",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = black,
                        fontSize = 14.sp
                    )
                )
                Text(
                    text = "Book Five Major Services and Get the Sixth one Free!",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 10.sp,
                        color = greyDark
                    )
                )
                15.dp.toheight()
                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_car_repair),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = black
                    )

                    8.dp.toWidth()

                    AndroidView(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .height(35.dp)
                            .offset(y = (-12).dp, x = 50.dp)
                            .scale(scaleX = 1.4f, scaleY = 0.9f)
                            .align(Alignment.CenterVertically),
                        factory = { context ->
                            ProgressStepperView(context).apply {
                                setMaxStepsCount(maxProgress)
                                setProgress(progress)
                                setTextSize(com.intuit.sdp.R.dimen._7sdp)
                            }
                        })


//                    LazyRow(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                    ) {
//                        items(maxProgress) { index ->
//                            if (index % 2 == 0)
//                                CurvedPipeUp(
//                                    index = index + 1,
//                                    color = if ((index+1)<= progress) green else grey,
//                                    modifier = Modifier.fillParentMaxWidth(fraction =(maxProgress/(maxProgress*5)).toFloat())
//                                ) else CurvedPipeDown(
//                                index = index + 1,
//                                color = if ((index+1)<= progress) green else grey,
//                                modifier = Modifier.fillParentMaxWidth(fraction = (maxProgress/(maxProgress*5)).toFloat())
//                            )
//                        }
//                    }

                    8.dp.toWidth()

                    Icon(
                        painter = painterResource(id = R.drawable.ic_gift),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = black
                    )
                }
                12.dp.toheight()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Terms and Conditions apply",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = black,
                            fontSize = 11.sp
                        )
                    )
                    ElevatedButton(
                        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                        modifier = Modifier.height(28.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors().copy(containerColor = grey),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 2.dp),
                        onClick = { /*TODO*/ }) {
                        Text(
                            text = "Book Now",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 12.sp,
                                color = white
                            )
                        )
                    }
                }

            }
        }
    }
}

@Composable
private fun CurvedPipeDown(index: Int, color: Color, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(top = 20.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Box(
                modifier = Modifier
                    .height(12.dp)
                    .width(3.dp)
                    .background(
                        color = color,
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 1.dp,
                            bottomEnd = 1.dp
                        )
                    )
            )
            Text(
                modifier = Modifier
                    .padding(0.dp)
                    .width(3.dp),
                text = "$index",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 8.sp,
                    color = color,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Box(
            modifier = Modifier
                .height(3.dp)
                .fillMaxWidth()
                .background(color = color, shape = RoundedCornerShape(0.dp))
        )
    }
}

@Composable
private fun CurvedPipeUp(index: Int, color: Color, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {

            Text(
                modifier = Modifier
                    .padding(0.dp)
                    .width(3.dp),
                text = "$index",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 8.sp,
                    color = color,
                    fontWeight = FontWeight.Bold
                )
            )
            Box(
                modifier = Modifier
                    .height(12.dp)
                    .width(3.dp)
                    .background(
                        color = color,
                        shape = RoundedCornerShape(
                            topStart = 1.dp,
                            topEnd = 1.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
            )
        }
        Box(
            modifier = Modifier
                .height(3.dp)
                .fillMaxWidth()
                .background(color = color, shape = RoundedCornerShape(0.dp))
        )
    }
}

@Composable
@Preview
private fun FreebiaseCardPreview() {
    FreebiaseCard(progress = 3, maxProgress = 20)
}