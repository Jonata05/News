package com.jonata.news.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jonata.core.navigation.type.NavGraphRoute
import com.jonata.feature_news.navigation.newsNavGraph


@Composable
fun NavHostApp(navHostController: NavHostController, startDestination: NavGraphRoute){


    NavHost(
        navHostController,
        startDestination = startDestination,
    ){
        newsNavGraph()
    }

}