package com.jonata.feature_news.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jonata.core.navigation.NewsNavGraphRoute
import com.jonata.feature_news.screens.newsdetails.NewsDetailsScreen
import com.jonata.feature_news.screens.newsscreen.NewsListScreen

fun NavGraphBuilder.newsNavGraph(){


    navigation<NewsNavGraphRoute.Root>(
        startDestination = NewsNavGraphRoute.NewsLogin){

        composable<NewsNavGraphRoute.NewsLogin>() {
            NewsListScreen()
        }


        composable<NewsNavGraphRoute.NewsHomeScreen>() {
            NewsDetailsScreen()
        }

    }

}