package com.jonata.domain.usecase.core

import com.jonata.domain.result.ResultTask
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCaseInBackground<INPUT,OUTPUT>(
    private val dispatcher: CoroutineDispatcher
) : UseCase<INPUT,OUTPUT> {


    override suspend fun execute(input: INPUT, result: (OUTPUT) -> Unit) {
        val item = withContext(dispatcher) { // executa em thread de I/O
            executeInBackground(input)
        }
            result(item)
    }

    abstract suspend fun executeInBackground(input: INPUT) : OUTPUT

}