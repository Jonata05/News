package com.jonata.domain.usecase.core

import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UseCaseExecute @Inject constructor(
    private val scope: CoroutineScope
) {



    operator fun <Input, Output>invoke(
        useCase: UseCase<Input,Output>,
        input: Input,
        onTaskResult: Output.() -> Unit
    ) {

        scope.launch {
            useCase.execute(input) { output ->

                onTaskResult(output)
            }
        }

    }
}