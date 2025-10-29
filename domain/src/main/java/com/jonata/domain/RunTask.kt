package com.jonata.domain

import javax.inject.Inject

class RunTask @Inject private constructor(private val exception: Exception? = null) {

    companion object{
        operator fun <T> invoke(task: () ->T ): RunTask{

            return try {
                task()
                RunTask(null)
            }catch (e: Exception){
                RunTask(e)
            }

        }
    }

    fun catchException(e:(Exception) -> Unit) : RunTask{

        if(exception != null){
            e(exception)
        }

        return this
    }

}

