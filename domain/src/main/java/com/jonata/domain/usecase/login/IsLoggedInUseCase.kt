package com.jonata.domain.usecase.login

import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.usecase.generics.UseCaseInBackground
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCaseInBackground<Unit, Boolean>(coroutineDispatcher) {


    override suspend fun executeInBackground(input: Unit): Boolean =
        authRepository.isLoggedIn()

}