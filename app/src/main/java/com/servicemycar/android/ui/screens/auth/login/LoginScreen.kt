package com.servicemycar.android.ui.screens.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.ui.helpers.toWidth
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.grey
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.SMCInputField
import com.servicemycar.android.ui.views.SMCPhonePicker
import com.servicemycar.android.ui.views.clickWithColorRipple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Enter Your Number",
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = black,
                            fontSize = 18.sp,
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }) {
                        Icon(
                            modifier = Modifier
                                .size(26.dp, 30.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(color = black)
                                .padding(horizontal = 6.dp, vertical = 6.dp),
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = null,
                            tint = white
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
            )
        },
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Spacer(modifier = Modifier.weight(1f))
            Card(
                colors = CardDefaults.cardColors(containerColor = white),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        SMCPhonePicker(
                            modifier = Modifier.width(120.dp),
                            backgroundColor = grey
                        )

                        10.dp.toWidth()
                        SMCInputField(
                            placeHolder = "Phone number", backgroundColor = grey,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Phone,
                                imeAction = ImeAction.Done
                            ),
                        )

                    }
                    15.dp.toheight()
                    Text("I Want To Change My Phone Number",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.clickWithColorRipple(
                            black, true
                        ) {
                            navController.navigate(NavigationItem.ChangePhone)
                        })
                    35.dp.toheight()
                    ElevatedButton(
                        onClick = {
                            navController.navigate(NavigationItem.OtpVerification(phone = "+971529447229"))
                        },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "LogIn",
                            style = MaterialTheme.typography.labelMedium.copy(color = white)
                        )
                    }
                    8.dp.toheight()
                    ElevatedButton(
                        onClick = {
                            navController.navigate(NavigationItem.SignUp)
                        },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "SignUp",
                            style = MaterialTheme.typography.labelMedium.copy(color = white)
                        )
                    }

                    20.dp.toheight()
                }

            }
        }
    }
}


@Composable
@Preview
private fun LoginScreenPreview() {
    LoginScreen(NavController(LocalContext.current))
}