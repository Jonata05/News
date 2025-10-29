package com.jonata.core.navigation

import com.jonata.core.navigation.type.NavGraphRoute
import kotlinx.serialization.Serializable


@Serializable
sealed class NewsNavGraphRoute {

    @Serializable
    data object Root: NavGraphRoute()

    @Serializable
    data object NewsList: NavGraphRoute()

    @Serializable
    data object ListDetail: NavGraphRoute()

}