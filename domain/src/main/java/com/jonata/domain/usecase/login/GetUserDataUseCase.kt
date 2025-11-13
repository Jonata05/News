package com.jonata.domain.usecase.login

import com.jonata.domain.model.Token
import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.usecase.generics.UseCaseInBackground
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
class GetUserDataUseCase @Inject constructor (
    private val authRepository: AuthRepository,
    dispatchers: CoroutineDispatcher
) : UseCaseInBackground<Unit, Token>(dispatchers) {

    override suspend fun executeInBackground(input: Unit): Token =
        authRepository.getToken()

}