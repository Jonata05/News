package com.jonata.domain.usecase.login

import com.jonata.domain.model.UserCredentials
import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.usecase.generics.UseCase
import com.jonata.domain.usecase.generics.UseCaseInBackground
import kotlinx.coroutines.CoroutineDispatcher

class SignUpUseCase(
    private val authRepository: AuthRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCaseInBackground<UserCredentials, Unit>(
    coroutineDispatcher
) {
    override suspend fun executeInBackground(input: UserCredentials) =
        authRepository.signUp(input)


}