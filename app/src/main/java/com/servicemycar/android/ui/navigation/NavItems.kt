package com.servicemycar.android.ui.navigation

import com.servicemycar.android.models.ServiceModel
import kotlinx.serialization.Serializable

enum class Screens {
    SPLASH,
    INTRO_SLIDER,
    LOGIN,
    SIGNUP,
    CHANGE_PHONE,
    OTP_VERIFICATION,
    HOME,
    SERVICE_DETAIL,
    SERVICE_BOOK,
    ORDER_INFORMATION,
    CHECKOUT,
    INVITE_FRIENDS,
    PAYMENT_CARDS,
    SUPPORT,
    MY_SERVICES,
}

@Serializable
sealed class NavigationItem(public val route: String) {
    @Serializable
    data object Splash : NavigationItem(Screens.SPLASH.name)

    @Serializable
    data object IntroSlider : NavigationItem(Screens.INTRO_SLIDER.name)

    @Serializable
    data object Login : NavigationItem(Screens.LOGIN.name)

    @Serializable
    data object SignUp : NavigationItem(Screens.SIGNUP.name)

    @Serializable
    data object ChangePhone : NavigationItem(Screens.CHANGE_PHONE.name)

    @Serializable
    data class OtpVerification(val phone:String) : NavigationItem(Screens.OTP_VERIFICATION.name)

    @Serializable
    data object Home : NavigationItem(Screens.HOME.name)

    @Serializable
    data class ServiceDetail(val service: ServiceModel) :
        NavigationItem(Screens.SERVICE_DETAIL.name)

    @Serializable
    data class ServiceBook(val service: ServiceModel) :
        NavigationItem(Screens.SERVICE_BOOK.name)

    @Serializable
    data class OrderInformation(val service: ServiceModel) :
        NavigationItem(Screens.ORDER_INFORMATION.name)

    @Serializable
    data class Checkout(val service: ServiceModel) :
        NavigationItem(Screens.CHECKOUT.name)

    @Serializable
    data object InviteFriends :
        NavigationItem(Screens.INVITE_FRIENDS.name)

    @Serializable
    data object PaymentCards:NavigationItem(Screens.PAYMENT_CARDS.name)

    @Serializable
    data object Support:NavigationItem(Screens.SUPPORT.name)

    @Serializable
    data object MyServices:NavigationItem(Screens.MY_SERVICES.name)
}