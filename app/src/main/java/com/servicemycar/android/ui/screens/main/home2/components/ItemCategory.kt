package com.servicemycar.android.ui.screens.main.home2.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.screens.main.home2.data.CategoryUI
import com.servicemycar.android.ui.screens.main.home2.data.staticCategories
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.green
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.red
import com.servicemycar.android.ui.theme.white


@Composable
fun ItemCategory(
    modifier: Modifier = Modifier,
    category: CategoryUI,
    isSelected: Boolean,
    showIcons:Boolean = true,
    onSelect: () -> Unit
) {
        Card(
            onClick = onSelect,
            colors = CardDefaults.cardColors(containerColor = if (isSelected) black else grey),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 12.dp)
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(4.dp),
                    ambientColor = green,
                    spotColor = green
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .widthIn(min = 70.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(showIcons) {
                    AnimatedContent(showIcons, label = "categoryIconAnim") {targetState ->
                        if(targetState)
                        Icon(
                            painter = painterResource(category.iconRes),
                            tint = if (isSelected) white else black,
                            contentDescription = category.title,
                            modifier = Modifier.size(36.dp)
                        )else 0.dp.toheight()
                    }

                }

               if(showIcons) 8.dp.toheight()
                Text(
                    category.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 13.sp,
                        color = if (isSelected) white else black,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
}


@Composable
@Preview
private fun ItemCategoryPreview(modifier: Modifier = Modifier) {
    SMCAndroidTheme {
        ItemCategory(category = staticCategories.first(), isSelected = true) {}
    }

}