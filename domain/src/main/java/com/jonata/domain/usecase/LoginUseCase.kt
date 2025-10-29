package com.jonata.domain.usecase

import android.R.attr.password
import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.result.ResultTask
import com.jonata.domain.usecase.core.UseCaseInBackground
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class LoginUseCase  (private val repository: AuthRepository,
     dispatchers: CoroutineDispatcher) :
    UseCaseInBackground<String, ResultTask<Unit>>(dispatchers) {

        override suspend fun executeInBackground(input: String): ResultTask<Unit> {
            return repository.login("", input)
        }
}