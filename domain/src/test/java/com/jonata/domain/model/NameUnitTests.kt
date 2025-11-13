package com.jonata.domain.model

import org.junit.Assert
import org.junit.Test

class NameUnitTests {

    @Test
    fun `when name has number _ throw exception`(){
        Assert.assertThrows(IllegalArgumentException::class.java){
            Name("Antonio Carlos 1" )
        }
    }

    @Test
    fun `when the the end of the name with "dos" "das" "do" "da" _ throw exception`(){

        Assert.assertThrows(IllegalArgumentException::class.java){
            Name("Antonio Carlos da" )
        }
        Assert.assertThrows(IllegalArgumentException::class.java){
            Name("Antonio Carlos da" )
        }
        Assert.assertThrows(IllegalArgumentException::class.java){
            Name("Antonio Carlos dos" )
        }
        Assert.assertThrows(IllegalArgumentException::class.java){
            Name("Antonio Carlos das" )
        }




    }

}