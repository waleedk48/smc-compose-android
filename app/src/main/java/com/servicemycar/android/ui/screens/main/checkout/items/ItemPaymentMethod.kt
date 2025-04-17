package com.servicemycar.android.ui.screens.main.checkout.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.greyDark
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.SmcListTile

@Composable
fun ItemPaymentMethod(
    icon:ImageVector =  Icons.Default.CreditCard,
    title:String = "Pay by Card",
    isSelected: Boolean = false, onSelect: (isSelected: Boolean) -> Unit = {}) {
        SmcListTile(
            modifier = Modifier.padding(vertical = 4.dp),
            padding = PaddingValues(vertical = 6.dp),
            onClick = {
                onSelect.invoke(!isSelected)
            },
            cardBackgroundColor = if (isSelected) black else white,
            leading = {
                Image(
                    icon,
                    contentDescription = "Icon of Payment method",
                    colorFilter = ColorFilter.tint(color = if (isSelected) white else black)
                )
            },
            title = {
                Text(
                    title,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 14.sp,
                        color = if (isSelected) white else black
                    )
                )
            },
            trailing = {

                Box(modifier = Modifier.size(24.dp)) {
                    Checkbox(
                        modifier = Modifier,
                        checked = isSelected,
                        onCheckedChange = onSelect,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = greyDark,
                            checkmarkColor = white,
                            checkedColor = black

                        ),

                        )
                }
            }
        )
    }


@Composable
@Preview(showSystemUi = false)
private fun ItemPaymentMethodPreview() {
    ItemPaymentMethod()
}