package com.jonata.core.components

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.SharedFlow


object SnackBarManager  {

    val snackBarHostState
        get() = SnackbarHostState()



    @Composable
    fun SnackBarHost()= SnackbarHost(snackBarHostState)



    @Composable
    fun ShowMessage(
        message: SharedFlow<String>,
        actionLabel: String? = null,
        duration: SnackbarDuration = SnackbarDuration.Short
    ) {
        LaunchedEffect(Unit) {

            message.collect {message ->
                snackBarHostState.showSnackbar(
                    message = message,
                    actionLabel = actionLabel,
                    duration = duration
                )
            }
        }
    }



}




