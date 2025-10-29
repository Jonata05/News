package com.jonata.feature_news.screens.newsscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonata.domain.usecase.LoginUseCase
import com.jonata.domain.usecase.core.UseCaseExecute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val useCaseExecutor: UseCaseExecute
) : ViewModel() {



    private val _token = MutableStateFlow("")
    val token: StateFlow<String> = _token



    fun loginUseCase(){

         useCaseExecutor(loginUseCase, input = "",){

             isSuccess {

             }

             isFailure {

             }

        }

    }


    fun login(){
        viewModelScope.launch {
            Log.d("Maria", "this")




            Log.d("Maria", "this")
        }
    }



}