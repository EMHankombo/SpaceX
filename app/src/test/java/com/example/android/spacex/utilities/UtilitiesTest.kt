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

    @Test
    fun `given 2 dates return the difference between them`(){
        val date1 = "2020-01-01T22:30:00.000Z"
        val date2 = "2020-01-10T22:30:00.000Z"
        val difference = 9

        assertEquals(difference,Utilities.getDaysBetweenDates(date1,date2))
    }
}