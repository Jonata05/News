package com.jonata.domain.generics

sealed class ResultRunTask<out T> (){
    data class Success<out T>(val result: T) : ResultRunTask<T>()
    data class Failure(val error: Throwable) : ResultRunTask<Nothing>()

}
class Validate<out T> private constructor(
    private val value: T? = null,
    private val exception: Exception? = null
) {

    companion object {
        operator fun <T> invoke(task: () -> T): Validate<T> {
            return try {
                Validate(value = task())
            } catch (e: Exception) {
                Validate(exception = e)
            }
        }
    }

    fun isSuccess(action: (T) -> Unit): Validate<T> {
        value?.let { action(it) }
        return this
    }

    fun catchException(action: (Exception) -> Unit): Validate<T> {
        exception?.let { action(it) }
        return this
    }
}
