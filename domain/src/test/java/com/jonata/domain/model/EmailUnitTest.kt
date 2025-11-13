package com.jonata.domain.model

import org.junit.Assert
import org.junit.Test
import java.lang.IllegalArgumentException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class EmailUnitTest {

    @Test
    fun `add email blank`() {

        Assert.assertThrows(IllegalArgumentException::class.java){
            Email("")
        }
    }

    @Test
    fun `name invalid`(){
        Assert.assertThrows(IllegalArgumentException::class.java){
            Email("jntval")
        }

        Assert.assertThrows(IllegalArgumentException::class.java){
            Email("@jntval")
        }
        Assert.assertThrows(
            IllegalArgumentException::class.java){
            Email("jntval@")
        }
    }

    @Test
    fun `email valid`(){

        val email = Email("example@gmail.com")

        Assert.assertEquals("example@gmail.com",email.get())

    }
}