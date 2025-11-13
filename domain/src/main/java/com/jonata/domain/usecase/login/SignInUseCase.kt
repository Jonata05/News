package com.jonata.domain.usecase.login

import com.jonata.domain.model.UserCredentials
import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.usecase.generics.UseCaseInBackground
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SignInUseCase @Inject constructor (
    private val authRepository: AuthRepository,
    dispatchers: CoroutineDispatcher
) : UseCaseInBackground<UserCredentials, Unit>(dispatchers) {



    override suspend fun executeInBackground(input: UserCredentials)  =
        authRepository.signIn(userCredentials = input )


}