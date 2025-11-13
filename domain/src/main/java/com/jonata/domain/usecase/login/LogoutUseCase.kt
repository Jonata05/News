package com.jonata.domain.usecase.login

import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.usecase.generics.UseCaseInBackground
import kotlinx.coroutines.CoroutineDispatcher

class LogoutUseCase(private val authRepository: AuthRepository,
    coroutineDispatcher: CoroutineDispatcher)
    : UseCaseInBackground<Unit, Unit> (
    coroutineDispatcher
){
    override suspend fun executeInBackground(input: Unit) =
        authRepository.logout()


}