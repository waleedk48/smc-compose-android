package com.servicemycar.android.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.transparent
import com.servicemycar.android.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConcernInputField(
    placeHolder:String = "Place holder"
) {
    var concern by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.fillMaxWidth().scale(scaleY = 0.95F, scaleX = 1F).wrapContentHeight().height(45.dp),
        value = concern,
        onValueChange = { newValue ->
            concern = newValue
        },
        maxLines = 1,
        placeholder = {
            Text(
                placeHolder,
                style = MaterialTheme.typography.bodySmall.copy(color = greyHint, fontSize = 12.sp, platformStyle = PlatformTextStyle(includeFontPadding = false))
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = white,
            unfocusedContainerColor = white,
            errorContainerColor = white,
            focusedIndicatorColor = transparent,
            unfocusedIndicatorColor = transparent,
            disabledIndicatorColor = transparent,
            errorIndicatorColor = transparent
        ),
        shape = RoundedCornerShape(4.dp),
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontSize = 12.sp,
            color = black,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                tint = white,
                contentDescription = "Clear concern",
                modifier = Modifier
                    .size(width = 20.dp, height = 20.dp)
                    .background(black, RoundedCornerShape(4.dp))

                    .clickWithColorRipple(
                        white, true
                    ) {
                        concern = ""
                    },
            )
        }
    )
}


@Composable
@Preview(showBackground = false)
private fun ConcernInputFieldPreview() {
    ConcernInputField(placeHolder = "Concern one")
}