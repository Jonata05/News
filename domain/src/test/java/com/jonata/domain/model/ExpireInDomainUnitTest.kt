package com.jonata.domain.model

import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class ExpireInDomainUnitTest {

    @Test
    fun `when date is expired _ return false`(){

        val check = ExpireInDomain(129321)
        Assert.assertEquals(false, check.isUpdated())
    }

    @Test
    fun `when the time is greater than the current time _ return true`(){
        val check = ExpireInDomain(System.currentTimeMillis() + 33)
        Assert.assertEquals(true, check.isUpdated())
    }


    @Test
    fun `return date whit format "dd MM yy"`(){
        val check = ExpireInDomain(1763037685688)
        Assert.assertEquals("13/11/25",check.getLabel())
    }
}