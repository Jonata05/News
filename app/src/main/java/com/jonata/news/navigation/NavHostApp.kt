package com.jonata.news.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jonata.core.navigation.NewsNavGraphRoute
import com.jonata.core.navigation.type.NavGraphRoute
import com.jonata.feature_news.navigation.newsNavGraph
import com.jonata.feature_news.screens.newsdetails.HomeScreen


@Composable
fun NavHostApp(navHostController: NavHostController, startDestination: NavGraphRoute){



    NavHost(
        navHostController,
        startDestination = startDestination,
    ){
        newsNavGraph()

        composable<NewsNavGraphRoute.NewsHomeScreen>() {
            HomeScreen()
        }

    }

}