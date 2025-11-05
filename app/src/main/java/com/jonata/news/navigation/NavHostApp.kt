package com.jonata.news.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jonata.core.navigation.NavRoute
import com.jonata.feature_login.navigation.newsNavGraph
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