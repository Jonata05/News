package com.jonata.domain.result

import com.jonata.domain.RunTask

enum class ResultState { Uninitialized, Success, Error }


 class ResultTask< out T> private constructor(
    private var value: T? = null
){


     companion object{

         fun <I> success(result: I): ResultTask<I> {

             val resultTask =
                 ResultTask(result)
             resultTask.state = ResultState.Success

             return resultTask
         }


         fun <T> error(e: Exception): ResultTask<T> {

             val resultTask =
                 ResultTask(null)

             resultTask.exception = e


             return resultTask
         }

     }



    private var state: ResultState = ResultState.Uninitialized



     fun isSuccess(task: (T) -> Unit) : ResultTask<T> {

        if (state == ResultState.Success) {
            task(value!!)
        }

         return this
    }


    private var exception = Exception()

     fun isFailure(task: (error: DomainError) -> Unit) {
        if (state == ResultState.Error) {

            val domainError = DomainErrorMapper.map(exception)

            task(domainError)
        }
    }



}




fun sendData(result:ResultTask<String>.() -> Unit) {

    RunTask{
        val item = ResultTask.success("oi")

        result(item)
    }.catchException { e ->

        val item = ResultTask.error<String>(e)
        result(item)
    }


}



