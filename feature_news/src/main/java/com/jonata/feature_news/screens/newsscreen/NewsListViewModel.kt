package com.jonata.feature_news.screens.newsscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonata.domain.model.UserCredentials
import com.jonata.domain.model.Email
import com.jonata.domain.model.Password
import com.jonata.domain.usecase.login.LoginUseCase
import com.jonata.domain.usecase.generics.UseCaseExecutor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val useCaseExecutor: UseCaseExecutor
) : ViewModel() {



    private val _token = MutableStateFlow("")
    val token: StateFlow<String> = _token



    fun loginUseCase(){

    Log.d("LoginInBackground", "Login")

        val userCredentials = UserCredentials(
            email = Email("jntferreiratj@hotmail.com"),
            password = Password("Reis1914")
        )

         useCaseExecutor(loginUseCase, userCredentials){

             isSuccess {


             }

             isFailure {

             }

        }

    }





}