package com.jonata.news.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jonata.core.navigation.NavigateManager
import com.jonata.core.navigation.NavRoute
import com.jonata.feature_auth.navigation.newsNavGraph
import com.jonata.news.ui.splash.splashScreen


@Composable
fun NavHostApp(navHostController: NavHostController, startDestination: NavRoute){

    val navigateManager = remember { NavigateManager(navHostController)  }

    NavHost(
        navHostController,
        startDestination = startDestination,
    ){


        newsNavGraph(navigateManager)

        splashScreen(navigateManager)

    }
}