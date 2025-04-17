package com.servicemycar.android.ui.screens.main.home.composes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicemycar.android.R
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(onIconClick:() -> Unit){
        TopAppBar(
            windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = backgroundColor,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            navigationIcon = {
                IconButton(
                    onClick = onIconClick) {
                    Icon(
                        modifier = Modifier
                            .size(26.dp, 30.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(color = black)
                            .padding(horizontal = 6.dp, vertical = 6.dp),
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = null,
                        tint = white
                    )
                }
            },
            title = {
                Column {
                    Text(
                        text = "Select your car",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = black,
                            fontSize = 12.sp
                        )
                    )
                    Text(
                        "Nissan Altima 2019",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = black,
                            fontSize = 10.sp
                        )
                    )
                }

            },
            actions = {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(color = black)
                        .padding(horizontal = 18.dp, vertical = 1.dp)


                ) {
                    Text(
                        text = "Wallet", style = MaterialTheme.typography.bodySmall.copy(color = white, fontSize = 11.sp))
                    Text(text = "AED 0", style = MaterialTheme.typography.bodySmall.copy(color = white, fontSize = 11.sp))
                }
            }
        )
    }


@Composable
@Preview(showBackground = false)
private fun HomeAppBarPreview(){
    HomeAppBar{}
}