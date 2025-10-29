package com.jonata.domain.usecase.core

import com.jonata.domain.result.ResultTask

interface UseCase<INPUT, OUTPUT> {

    suspend fun execute(input: INPUT, result: (OUTPUT) -> Unit)

}