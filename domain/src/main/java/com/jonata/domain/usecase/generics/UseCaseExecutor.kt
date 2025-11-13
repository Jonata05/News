package com.jonata.domain.usecase.generics

import android.util.Log
import com.jonata.domain.ErrorDomain.DomainErrorMapper
import com.jonata.domain.ErrorDomain.ResultTask
import com.jonata.domain.ErrorDomain.TaskState
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UseCaseExecutor @Inject constructor(
    private val scope: CoroutineScope
) {



    operator fun <Input, Output>invoke(
        useCase: UseCase<Input, Output>,
        input: Input,
        state: (TaskState) -> Unit ={},
        onTaskResult: ResultTask<Output>.() -> Unit
    ) {

        scope.launch {

            state(TaskState.Loading)

            try {

                useCase.execute(input) { output ->
                    Log.d("UseCaseExecutor", "${useCase::class.simpleName}: succeeded -> $output")
                    val result = ResultTask.success(output)
                    onTaskResult(result)
                    state(TaskState.Success)
            }
            }catch (e: Exception){

                Log.e("UseCaseExecutor", "${useCase::class.simpleName}",e)
                val domainError = DomainErrorMapper.map(e)
                val result = ResultTask.failure<Output>(domainError)
                onTaskResult(result)
                state(TaskState.Failure)

            }

            state(TaskState.Uninitialized)

        }

    }
}