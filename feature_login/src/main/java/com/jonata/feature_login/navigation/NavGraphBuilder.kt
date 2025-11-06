package com.jonata.feature_login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jonata.feature_login.screens.home.HomeScreen
import com.jonata.feature_login.screens.login.LoginScreen

fun NavGraphBuilder.newsNavGraph(
    navController: NavController
){


    navigation<NewsNavGraphRoute.Root>(
        startDestination = NewsNavGraphRoute.NewsLoginScreen){

        composable<NewsNavGraphRoute.NewsLoginScreen>() {
            LoginScreen(navController = navController)
        }


        composable<NewsNavGraphRoute.NewsHomeScreen>() {
            HomeScreen(navController = navController)
        }

    }

}