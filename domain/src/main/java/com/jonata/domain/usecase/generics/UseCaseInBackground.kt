package com.jonata.domain.usecase.generics

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCaseInBackground<INPUT,OUTPUT>(
    private val coroutineDispatcher: CoroutineDispatcher
) : UseCase<INPUT,OUTPUT> {


    override suspend fun execute(input: INPUT, result: (OUTPUT) -> Unit) {
        val item = withContext(coroutineDispatcher) { // executa em thread de I/O
            executeInBackground(input)
        }
            result(item)
    }

    abstract suspend fun executeInBackground(input: INPUT) : OUTPUT

}