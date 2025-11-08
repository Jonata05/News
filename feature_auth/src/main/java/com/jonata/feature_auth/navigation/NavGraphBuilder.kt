package com.jonata.feature_auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jonata.core.navigation.NavigateManager
import com.jonata.feature_auth.screens.home.HomeScreen
import com.jonata.feature_auth.screens.login.LoginScreen

fun NavGraphBuilder.newsNavGraph(
    navigateManager: NavigateManager
){


    navigation<NewsNavGraphRoute.Root>(
        startDestination = NewsNavGraphRoute.NewsLoginScreen){

        composable<NewsNavGraphRoute.NewsLoginScreen>() {
            LoginScreen( navigateManager)
        }


        composable<NewsNavGraphRoute.NewsHomeScreen>() {
            HomeScreen(navigateManager)
        }

    }

}