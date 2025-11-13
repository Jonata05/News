package com.jonata.domain.usecase.generics

interface UseCase<INPUT, OUTPUT> {

    suspend fun execute(input: INPUT, result: (OUTPUT) -> Unit)

}