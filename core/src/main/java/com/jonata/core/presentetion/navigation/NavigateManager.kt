package com.jonata.core.presentetion.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import kotlinx.coroutines.flow.SharedFlow

class NavigateManager(private val navController: NavController){

    @Composable
    fun PopUpTo(navigate: SharedFlow<NavRoute>, ) {

        LaunchedEffect(Unit) {
            navigate.collect { route ->
                navController.navigate(route) {
                    popUpTo(0) { inclusive = true }
                }
            }
        }
    }


    @Composable
    fun PopBackStack(navigate: SharedFlow<NavRoute>, ) {

        LaunchedEffect(Unit) {
            navigate.collect { route ->
                navController.popBackStack()
            }
        }
    }

    @Composable
    fun LaunchSingleTop(navigate: SharedFlow<NavRoute>){
            LaunchedEffect(Unit) {
                navigate.collect { route ->

                    navController.navigate(navigate
                    ) {
                        launchSingleTop = true
                    }
                }


        }
    }

}