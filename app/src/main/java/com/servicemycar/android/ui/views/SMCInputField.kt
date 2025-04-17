package com.servicemycar.android.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.greyHint
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.theme.transparent
import com.servicemycar.android.ui.theme.white

@Composable
fun SMCInputField(
    modifier: Modifier = Modifier,
    placeHolder: String = "Place holder",
    backgroundColor: Color = white,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions()
) {
    var value by remember { mutableStateOf("") }
    TextField(
        modifier =  modifier
            .fillMaxWidth()
            .scale(scaleY = 0.95F, scaleX = 1F)
            .wrapContentHeight()
            .height(45.dp)
            .border(BorderStroke(1.dp, color = backgroundColor), RoundedCornerShape(8.dp)),
        value = value,
        onValueChange = { newValue ->
            value = newValue
        },
        maxLines = 1,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        placeholder = {
            Text(
                placeHolder,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = greyHint,
                    fontSize = 12.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                )
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = transparent,
            unfocusedContainerColor = backgroundColor,
            errorContainerColor = backgroundColor,
            focusedIndicatorColor = transparent,
            unfocusedIndicatorColor = transparent,
            disabledIndicatorColor = transparent,
            errorIndicatorColor = transparent
        ),
        shape = RoundedCornerShape(8.dp),
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontSize = 12.sp,
            color = black,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),

    )
}


@Composable
@Preview(showBackground = false)
private fun SMCInputFieldPreview() {
    SMCInputField()
}