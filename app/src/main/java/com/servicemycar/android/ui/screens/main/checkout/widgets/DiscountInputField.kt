package com.servicemycar.android.ui.screens.main.checkout.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.transparent
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.clickWithColorRipple


@Composable
fun DiscountInputField(
    modifier: Modifier = Modifier
) {
    var discountCoupon by remember { mutableStateOf("") }
    var isDiscountApplied by remember { mutableStateOf(false) }
    TextField(
        modifier = modifier,
        enabled = !isDiscountApplied,
        value = discountCoupon,
        onValueChange = { newValue -> discountCoupon = newValue },
        maxLines = 1,

        placeholder = {
            Text(
                "Discount Code",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = greyHint,
                    fontSize = 14.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                )
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = white,
            unfocusedContainerColor = white,
            disabledContainerColor = black,
            errorContainerColor = white,
            focusedIndicatorColor = transparent,
            unfocusedIndicatorColor = transparent,
            disabledIndicatorColor = transparent,
            errorIndicatorColor = transparent
        ),
        shape = RoundedCornerShape(4.dp),
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontSize = 14.sp,
            color = if (isDiscountApplied) white else black,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),

        trailingIcon = {
            if (!isDiscountApplied) {
                ElevatedAssistChip(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = {
                        isDiscountApplied = true
                    },
                    label = {
                        Text("Apply",
                            style = MaterialTheme.typography.labelLarge.copy(fontSize = 10.sp, color = white),)
                    },
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(width = 0.dp, color = transparent),
                    colors = AssistChipDefaults.assistChipColors(containerColor = black.copy(alpha = 0.95f),),
                    elevation = AssistChipDefaults.elevatedAssistChipElevation(elevation = 0.5.dp)
                )
//                Text("Apply",
//                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 12.sp),
//                    modifier = Modifier
//                        .padding(horizontal = 8.dp, vertical = 4.dp)
//                        .clickWithColorRipple(
//                            black, true
//                        ) {
//                            if (discountCoupon.isNotBlank())
//                                isDiscountApplied = true
//                        })
            } else {
                ElevatedAssistChip(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = {
                        isDiscountApplied = false
                    },
                    label = {
                        Text("Applied",
                            style = MaterialTheme.typography.labelLarge.copy(fontSize = 10.sp, color = black),)
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Close,
                            tint = black,
                            contentDescription = "Clear Discount Code",
                            modifier = Modifier
                                .size(width = 18.dp, height = 20.dp)
                                .clickWithColorRipple(
                                    white, true
                                ) {
                                   isDiscountApplied = false
                                },
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(width = 0.dp, color = transparent),
                    colors = AssistChipDefaults.assistChipColors(containerColor = white.copy(alpha = 0.95f),),
                    elevation = AssistChipDefaults.elevatedAssistChipElevation(elevation = 0.5.dp)
                )
//                Row(
//                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text("Applied",
//                        style = MaterialTheme.typography.labelMedium.copy(color = white, fontSize = 12.sp),
//                        modifier = Modifier
//                            .clickWithColorRipple(
//                                white, true
//                            ) {
//                                isDiscountApplied = false
//                            })
//                    5.dp.toWidth()
//                    Icon(
//                        imageVector = Icons.Default.Close,
//                        tint = white,
//                        contentDescription = "Clear Discount Code",
//                        modifier = Modifier
//                            .size(width = 20.dp, height = 20.dp)
//                            .clickWithColorRipple(
//                                white, true
//                            ) {
//                                isDiscountApplied = false
//                            },
//                    )
//                }
            }
        }
    )
}


@Composable
@Preview
private fun DiscountInputFieldPreview() {
    DiscountInputField()
}