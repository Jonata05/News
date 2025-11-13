package com.jonata.feature_auth.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonata.core.presentetion.navigation.NavRoute
import com.jonata.domain.model.UserCredentials
import com.jonata.domain.model.Email
import com.jonata.domain.model.Password
import com.jonata.domain.generics.Validate
import com.jonata.domain.usecase.login.SignInUseCase
import com.jonata.domain.usecase.generics.UseCaseExecutor
import com.jonata.feature_auth.navigation.NewsNavGraphRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signUpUseCase: SignInUseCase,
    private val useCaseExecutor: UseCaseExecutor
) : ViewModel() {

    private val _navigate = MutableSharedFlow<NavRoute>()
    val navigate = _navigate.asSharedFlow()

    private val _snackBarMessage = MutableSharedFlow<String>()
    val snackBarMessage = _snackBarMessage.asSharedFlow()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password



    fun updateEmail(value: String){
        _email.value = value
    }

    fun updatePassword(value: String){
        _password.value = value
    }


    fun sendCredentials(){
        Validate {
            UserCredentials(
                email = Email(email.value),
                password = Password(password.value)
            )
        }.isSuccess { login(it) }.catchException { e-> }
    }

    fun login(userCredentials: UserCredentials){

            useCaseExecutor(signUpUseCase, userCredentials) {

                isSuccess {
                    viewModelScope.launch {
                        _navigate.emit(NewsNavGraphRoute.NewsHomeScreen)
                    }
                }

                isFailure {error ->
                    Log.d("casaboas","casaboas")
                    viewModelScope.launch {
                        _snackBarMessage.emit(error.getMessage)
                    }
                }

            }
    }
}