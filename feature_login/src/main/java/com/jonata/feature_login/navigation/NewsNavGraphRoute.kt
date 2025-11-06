package com.jonata.feature_login.navigation

import com.jonata.core.navigation.NavRoute
import kotlinx.serialization.Serializable


@Serializable
sealed class NewsNavGraphRoute: NavRoute {

    @Serializable
    data object Root :NewsNavGraphRoute()

    @Serializable
    data object NewsLoginScreen:NewsNavGraphRoute()

    @Serializable
    data object NewsHomeScreen:NewsNavGraphRoute()

}
