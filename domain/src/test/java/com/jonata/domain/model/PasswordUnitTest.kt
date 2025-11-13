package com.jonata.domain.model

import org.junit.Assert
import org.junit.Test

class PasswordUnitTest {

    val illegalArgumentException = IllegalArgumentException::class.java

    @Test
    fun `when password has not number _ throw exception`(){
        Assert.assertThrows(illegalArgumentException){
            Password("")
        }
    }

    @Test
    fun `when password has less than eight characters should _ throw exception`(){
        Assert.assertThrows(illegalArgumentException){
            Password("@Jon89")
        }
    }

    @Test
    fun `when password han not have number _ trow exception`(){
        Assert.assertThrows(illegalArgumentException){
            Password("AfeTdaSdaS")
        }
    }



    @Test
    fun `add email blank`(){
        Assert.assertThrows(IllegalArgumentException::class.java){
            Password("")
        }
    }

    @Test
    fun `password is valid`(){

        val password = Password("@DansT1734")

        Assert.assertEquals("@DansT1734", password.get())

    }

}