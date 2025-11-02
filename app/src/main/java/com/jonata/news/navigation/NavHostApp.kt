package com.jonata.news.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jonata.core.navigation.NavRoute
import com.jonata.feature_login.navigation.NewsNavGraphRoute
import com.jonata.feature_login.navigation.newsNavGraph
import com.jonata.feature_login.screens.newsdetails.HomeScreen
import com.jonata.news.ui.splash.splashScreen


@Composable
fun NavHostApp(navHostController: NavHostController, startDestination: NavRoute){



    NavHost(
        navHostController,
        startDestination = startDestination,
    ){
        newsNavGraph(navHostController)


        splashScreen(navHostController)



    }

}