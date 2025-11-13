package com.jonata.core.presentetion.feedback

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

object SnackBarManager {


    val snackBarHost
        @Composable
        get() = SnackbarHost(hostState = snackBarHostState)


    val snackBarHostState = SnackbarHostState()



    private val _snackBarMessage = MutableSharedFlow<String>()
    private val snackBarMessage = _snackBarMessage.asSharedFlow()


    fun emit(coroutineScope: CoroutineScope, message: String){

        coroutineScope.launch {
            _snackBarMessage.emit(message)
        }

    }


    @Composable
    fun ListenMessages(
        actionLabel: String? = null,
        duration: SnackbarDuration = SnackbarDuration.Short
    ) {

        LaunchedEffect(snackBarMessage) {

            snackBarMessage.collect {message ->
                snackBarHostState.showSnackbar(
                    message = message,
                    actionLabel = actionLabel,
                    duration = duration
                )
            }
        }
    }

}












