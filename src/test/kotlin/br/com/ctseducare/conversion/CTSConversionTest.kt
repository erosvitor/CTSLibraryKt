/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.conversion

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CTSConversionTest {

    @Test
    fun testSecondsToHours() {
        assertEquals("01:00:00", CTSConversion.secondsToHours(3600))
    }

    @Test
    fun testHoursToSeconds() {
        assertEquals(3600, CTSConversion.hoursToSeconds("01:00:00"))
    }

}