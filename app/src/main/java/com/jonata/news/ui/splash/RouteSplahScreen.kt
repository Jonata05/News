package com.jonata.news.ui.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jonata.core.presentetion.navigation.NavigateManager
import com.jonata.core.presentetion.navigation.NavRoute
import kotlinx.serialization.Serializable


@Serializable
object RouteSplashScreen : NavRoute

fun NavGraphBuilder.splashScreen(
    navigateManager: NavigateManager
){

    composable <RouteSplashScreen> {
        SplashScreen(navigateManager = navigateManager)
    }



}