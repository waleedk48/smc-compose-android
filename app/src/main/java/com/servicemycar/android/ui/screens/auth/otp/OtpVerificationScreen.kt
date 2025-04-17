package com.servicemycar.android.ui.screens.auth.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.navigation.NavigationItem
import com.servicemycar.android.ui.theme.backgroundColor
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white
import com.servicemycar.android.ui.views.CountdownTimer
import com.servicemycar.android.ui.views.OtpInputField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpVerificationScreen(
    navController: NavController,
    phoneNumber: String,
) {
    var timer by remember { mutableLongStateOf(30L) }

    var otpValue by remember { mutableStateOf("") }
    var isOtpFilled by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current



    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(top = 24.dp, bottom = 8.dp),
                title = {
                    Text(
                        text = "Enter the Code",
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

            Text(
                buildAnnotatedString {

                    append("We have sent an OTP verification code of 4 digits on your registered mobile phone number")
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = black,
                            fontWeight = FontWeight.Bold,
                            //textDecoration = TextDecoration.LineThrough
                        )
                    ) {
                        append("(**) ** ***7229")
                    }
                    append(".\n")
                    append("\n")
                    append("Please enter that code to proceed. In case you have not received the code please press the resend button to get verification code again!")

                },
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)
            )
            24.dp.toheight()
            Card(
                colors = CardDefaults.cardColors(containerColor = white),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    24.dp.toheight()
                    OtpInputField(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(),
                        otpText = otpValue, otpLength = 4,
                        shouldCursorBlink = false
                    ) { value, otpFilled ->
                        otpValue = value
                        isOtpFilled = otpFilled
                        if (otpFilled) {
                            keyboardController?.hide()
                        }
                    }

                    24.dp.toheight()
                    ElevatedButton(
                        onClick = {
                            navController.navigate(NavigationItem.Home) {
                                popUpTo(0) {
                                    inclusive = true
                                }
                            }
                        },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Verify Otp",
                            style = MaterialTheme.typography.labelMedium.copy(color = white)
                        )
                    }

                    16.dp.toheight()

                    CountdownTimer(
                        duration = 120,
                        onTick = {
                            timer = it
                        }, onFinish = {
                            timer = 0L
                        })
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Composable
@Preview
private fun OtpVerificationScreenPreview() {
    OtpVerificationScreen(
        navController = NavController(LocalContext.current),
        phoneNumber = "+971 52 944 7229"
    )
}