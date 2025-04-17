package com.servicemycar.android.ui.screens.main.profile.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.servicemycar.android.ui.screens.main.profile.cards.components.NoCardView
import com.servicemycar.android.ui.screens.main.profile.cards.components.PaymentCardItem
import com.servicemycar.android.ui.screens.main.profile.cards.components.ShowAddCardBottomSheet
import com.servicemycar.android.ui.screens.main.profile.cards.components.ShowCrudPaymentDialog
import com.servicemycar.android.ui.theme.SMCAndroidTheme
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.views.clickWithColorRipple



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentCardsScreen(navController: NavController) {

    var showAddCardSheet by remember { mutableStateOf(false) }
    var showCardsList by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundColor),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = black,
                        contentDescription = "goBack",
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .background(
                                grey, RoundedCornerShape(4.dp)
                            )
                            .padding(4.dp)
                            .clickWithColorRipple(black, true) {
                                navController.navigateUp()
                            }
                    )
                },
                title = { Text("My Payment Cards", style = MaterialTheme.typography.labelMedium) }
            )
        }
    ) { paddingValues ->

        if (showAddCardSheet) ShowAddCardBottomSheet {
            showAddCardSheet = it
            showCardsList = true
        }

        if (showDeleteDialog) ShowCrudPaymentDialog {
            showDeleteDialog = it
        }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = if (showCardsList) Arrangement.Top else Arrangement.Center
        ) {
            if (showCardsList) {

                LazyColumn {
                    items(3) {
                        PaymentCardItem(isDefault = it == 0) {
                            showDeleteDialog = true
                        }
                    }
                }

            } else {
                NoCardView(onAddCardClick = {
                    showAddCardSheet = true
                })
            }

        }
    }
}


@Composable
@Preview
private fun PaymentCardsScreenPreview() {
    SMCAndroidTheme {
        PaymentCardsScreen(NavController(LocalContext.current))
    }

}