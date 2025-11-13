package com.jonata.news.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonata.core.presentetion.navigation.NavRoute
import com.jonata.domain.usecase.generics.UseCaseExecutor
import com.jonata.domain.usecase.login.IsLoggedInUseCase
import com.jonata.feature_auth.navigation.NewsNavGraphRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel@Inject constructor(
    private val useCaseExecutor: UseCaseExecutor,
    private val isLoggedInUseCase: IsLoggedInUseCase
) : ViewModel() {


    private val _initScreen = MutableSharedFlow<NavRoute>()
    val initScreen = _initScreen.asSharedFlow()


    init {
        defineInitScreen()
    }

    fun defineInitScreen(){
        useCaseExecutor(isLoggedInUseCase, input = Unit){
            isSuccess { userIsLogged ->
                viewModelScope.launch {
                    when(userIsLogged) {
                        true -> { _initScreen.emit(NewsNavGraphRoute.NewsHomeScreen) }
                        false -> { _initScreen.emit(NewsNavGraphRoute.NewsLoginScreen) }
                    }
                }
            }


        }

    }



}