package com.jonata.domain.ErrorDomain

enum class TaskState { Uninitialized, Success, Failure, Loading }


 class ResultTask< out T> private constructor(
    private var value: T?,
    private var domainError: DomainError?
){


     companion object{

         fun <I> success(result: I): ResultTask<I> {

             val resultTask =
                 ResultTask(result, null)

             return resultTask
         }


         fun <T> failure(e: DomainError): ResultTask<T> {

             val resultTask =
                 ResultTask(value = null, domainError =  e)

             return resultTask
         }

     }




     fun isSuccess(task: (T) -> Unit) =         value?.let { task(it) }




     fun isFailure(task: (errorException: DomainError) -> Unit) {
         domainError?.let { task(it) }
     }



}








