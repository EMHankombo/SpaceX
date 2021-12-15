package com.example.android.spacex.utilities

import com.example.android.spacex.utils.Utilities
import org.junit.Assert.*
import org.junit.Test

class UtilitiesTest {

    @Test
    fun `correctly return date only`(){
        val dateGiven = "2006-03-24T22:30:00.000Z"
        val expectedReturnedDate = "24-03-2006"
        assertEquals(expectedReturnedDate,Utilities.getDateOnly(dateGiven))
    }
}