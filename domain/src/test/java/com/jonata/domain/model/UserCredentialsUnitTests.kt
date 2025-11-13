package com.jonata.domain.model

import org.junit.Assert
import org.junit.Test

class UserCredentialsUnitTests {
    @Test
    fun `when email and password is equals _ throw exception`(){
        val email = Email("example1@gmail.com")
        val password = Password("example1@gmail.com")
        Assert.assertThrows(IllegalArgumentException::class.java){
            UserCredentials(email,password)
        }
    }
}