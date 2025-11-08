package com.jonata.core.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.jonata.core.navigation.NavRoute
import kotlinx.coroutines.flow.SharedFlow

@Composable
 fun NavigateTo(navigate: SharedFlow<NavRoute>, navController: NavController) {

    LaunchedEffect(Unit) {
        navigate.collect { route->
            navController.navigate(route) {
                popUpTo(0) { inclusive = true }
            }
        }
    }


}