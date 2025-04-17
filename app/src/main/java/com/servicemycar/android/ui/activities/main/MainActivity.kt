package com.servicemycar.android.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.servicemycar.android.ui.navigation.AppNavHost
import com.servicemycar.android.ui.theme.SMCAndroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SMCAndroidTheme {
                AppNavHost()
            }
        }
    }
}