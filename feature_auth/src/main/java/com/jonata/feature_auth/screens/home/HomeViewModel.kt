package com.jonata.feature_auth.screens.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonata.core.components.SnackBarManager
import com.jonata.core.navigation.NavRoute
import com.jonata.domain.usecase.generics.UseCaseExecutor
import com.jonata.domain.usecase.login.GetUserDataUseCase
import com.jonata.domain.usecase.login.LogoutUseCase
import com.jonata.feature_auth.navigation.NewsNavGraphRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCaseExecutor: UseCaseExecutor,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val logout: LogoutUseCase
) : ViewModel() {


    init {
        getUserData()
    }

    private val _navigate = MutableSharedFlow<NavRoute>()
    val navigate = _navigate.asSharedFlow()

    private val _idToken = MutableStateFlow("")
    val idToken: StateFlow<String> = _idToken

    private val _expiresAt = MutableStateFlow("")
    val expiresAt: StateFlow<String> = _expiresAt

    private val _refreshToken = MutableStateFlow("")
    val refreshToken: StateFlow<String> = _refreshToken

    private val _displayName = MutableStateFlow("")
    val displayName: StateFlow<String> = _displayName

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _registered = MutableStateFlow(false)
    val registered: StateFlow<Boolean> = _registered

    private val _localId = MutableStateFlow("")
    val localId: StateFlow<String> = _localId


    fun getUserData(){

        useCaseExecutor(getUserDataUseCase, Unit) {


            isSuccess { token->
                _idToken.value = token.getIdToken()
                _expiresAt.value = token.getExpiresInString()
                _refreshToken.value = token.getTokenRefresh()
                _displayName.value = token.getName()
                _email.value = token.getEmail()
                _registered.value = token.getRegistered()
                _localId.value = token.getLocalId()
            }

            isFailure {
            }
        }

    }

    fun logout(){

        useCaseExecutor(logout, Unit) {
            isSuccess {
                viewModelScope.launch {
                    _navigate.emit(NewsNavGraphRoute.NewsLoginScreen)
                }
            }
        }

    }



    fun feedback(){

        SnackBarManager.emit(viewModelScope,"Bom dia")

    }

}
