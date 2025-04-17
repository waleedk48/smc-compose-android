package com.servicemycar.android.ui.navigation

import android.util.Log
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.servicemycar.android.models.ServiceModel
import com.servicemycar.android.ui.screens.auth.change.ChangePhoneScreen
import com.servicemycar.android.ui.screens.auth.login.LoginScreen
import com.servicemycar.android.ui.screens.auth.otp.OtpVerificationScreen
import com.servicemycar.android.ui.screens.auth.signup.SignUpScreen
import com.servicemycar.android.ui.screens.drawer.invite.InviteFriendsScreen
import com.servicemycar.android.ui.screens.drawer.SmcDrawerScreen
import com.servicemycar.android.ui.screens.drawer.myservices.MyServicesScreen
import com.servicemycar.android.ui.screens.drawer.support.SupportScreen
import com.servicemycar.android.ui.screens.intro.IntroSliderScreen
import com.servicemycar.android.ui.screens.main.book.BookServiceNewScreen
import com.servicemycar.android.ui.screens.main.book.BookServiceScreen
import com.servicemycar.android.ui.screens.main.checkout.CheckOutScreen
import com.servicemycar.android.ui.screens.main.detail.ServiceDetailScreen
import com.servicemycar.android.ui.screens.main.home2.HomeScreen2
import com.servicemycar.android.ui.screens.main.orderinfo.OrderInformationScreen
import com.servicemycar.android.ui.screens.main.profile.cards.PaymentCardsScreen
import kotlinx.coroutines.launch
import kotlin.reflect.typeOf


@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home//NavigationItem.IntroSlider
    ) {
        composable<NavigationItem.IntroSlider> {
            IntroSliderScreen(navController = navController)
        }
        composable<NavigationItem.Login> {
            LoginScreen(navController = navController)
        }
        composable<NavigationItem.SignUp> {
            SignUpScreen(navController = navController)
        }
        composable<NavigationItem.ChangePhone> {
            ChangePhoneScreen(navController = navController)
        }

        composable<NavigationItem.OtpVerification>() {
            val arguments = it.toRoute<NavigationItem.OtpVerification>()
            OtpVerificationScreen(navController = navController, phoneNumber = arguments.phone)
        }

        composable<NavigationItem.Home> {
            HomeScreen2(
                navController = navController,
            )
        }
        composable<NavigationItem.ServiceDetail>(
            typeMap = mapOf(
                typeOf<ServiceModel>() to CustomNavType.ServiceType
            )
        ) {
            val arguments = it.toRoute<NavigationItem.ServiceDetail>()

            ServiceDetailScreen(navController = navController, serviceModel = arguments.service)
        }

        composable<NavigationItem.ServiceBook>(
            typeMap = mapOf(
                typeOf<ServiceModel>() to CustomNavType.ServiceType
            )
        ) {
            val arguments = it.toRoute<NavigationItem.ServiceDetail>()
           // BookServiceNewScreen(navController = navController, serviceModel = arguments.service)
            BookServiceScreen(navController = navController, serviceModel = arguments.service)
        }

        composable<NavigationItem.OrderInformation>(
            typeMap = mapOf(
                typeOf<ServiceModel>() to CustomNavType.ServiceType
            )
        ) {
            val arguments = it.toRoute<NavigationItem.ServiceDetail>()
            OrderInformationScreen(navController = navController, serviceModel = arguments.service)
        }
        composable<NavigationItem.Checkout>(
            typeMap = mapOf(
                typeOf<ServiceModel>() to CustomNavType.ServiceType
            )
        ) {
            val arguments = it.toRoute<NavigationItem.ServiceDetail>()
            CheckOutScreen(navController = navController, serviceModel = arguments.service)
        }

        composable<NavigationItem.InviteFriends> {
            InviteFriendsScreen(navController = navController) {
                scope.launch {
                    Log.d("DrawerUpdate", "AppNavHost: change drawer")
                    drawerState.open()
                }
            }
        }

        composable<NavigationItem.PaymentCards> {
            PaymentCardsScreen(navController = navController)
        }
        composable<NavigationItem.Support> {
            SupportScreen(navController = navController)
        }
        composable<NavigationItem.MyServices> {
            MyServicesScreen(navController = navController)
        }
    }

}

@Composable
@Preview
private fun AppNavHostPreview() {
    AppNavHost()
}

