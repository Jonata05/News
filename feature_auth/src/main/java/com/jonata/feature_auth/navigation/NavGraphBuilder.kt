package com.jonata.feature_auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jonata.feature_auth.screens.home.HomeScreen
import com.jonata.feature_auth.screens.login.LoginScreen

fun NavGraphBuilder.newsNavGraph(
    navController: NavController
){


    navigation<NewsNavGraphRoute.Root>(
        startDestination = NewsNavGraphRoute.NewsLoginScreen){

        composable<NewsNavGraphRoute.NewsLoginScreen>() {
            LoginScreen( navController)
        }


        composable<NewsNavGraphRoute.NewsHomeScreen>() {
            HomeScreen(navController)
        }

    }

}