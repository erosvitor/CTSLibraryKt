/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.date

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CTSDateTest {

    @Test
    fun testGetDayValid() {
        assertEquals(10, CTSDate.getDay("10/10/2010"))
    }

    @Test
    fun testGetMonthValid() {
        assertEquals(10, CTSDate.getMonth("10/10/2010"))
    }

    @Test
    fun testGetYearValid() {
        assertEquals(2010, CTSDate.getYear("10/10/2010"))
    }

}