/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class CTSValidationTest {

    //--------------------------------------------------------------------------------
    // Tests for validation of personal name
    //--------------------------------------------------------------------------------
    @Test
    fun testPersonalNameValid() {
        assertTrue(CTSValidation.personalNameIsValid("Eros Vitor"))
    }

    @Test
    fun testPersonalNameInvalid() {
        assertFalse(CTSValidation.personalNameIsValid("Eros 10 Vitor"))
    }

    @Test
    fun testPersonalNameBlank() {
        assertFalse(CTSValidation.personalNameIsValid(""))
    }

    //--------------------------------------------------------------------------------
    // Tests for validation of email
    //--------------------------------------------------------------------------------
    @Test
    fun testEmailValid() {
        assertTrue(CTSValidation.emailIsValid("email@yahoo.com.br"))
    }

    @Test
    fun testEmailInvalid() {
        assertFalse(CTSValidation.emailIsValid("email@yahoo"))
    }

    @Test
    fun testEmailBlank() {
        assertFalse(CTSValidation.emailIsValid(""))
    }

    //--------------------------------------------------------------------------------
    // Tests for validation of date
    //--------------------------------------------------------------------------------
    @Test
    fun testDateValid() {
        assertTrue(CTSValidation.dateIsValid("10/10/2010"))
    }

    @Test
    fun testDateInvalid() {
        assertFalse(CTSValidation.dateIsValid("10/20/2010"))
    }

    @Test
    fun testDateIncomplete() {
        assertFalse(CTSValidation.dateIsValid("10/20/"))
    }

    @Test
    fun testDateBlank() {
        assertFalse(CTSValidation.dateIsValid(""))
    }

    //--------------------------------------------------------------------------------
    // Tests for leap year
    //--------------------------------------------------------------------------------
    @Test
    fun testYearIsNotLeapYear() {
        assertFalse(CTSValidation.isLeapYear("10/10/2010"))
    }

    @Test
    fun testYearIsLeapYear() {
        assertTrue(CTSValidation.isLeapYear("10/10/2012"))
    }

    //--------------------------------------------------------------------------------
    // Tests for validation of CPF
    //--------------------------------------------------------------------------------
    @Test
    fun testCPFValid() {
        assertTrue(CTSValidation.cpfIsValid("28309200404"))
    }

    @Test
    fun testCPFInvalid() {
        assertFalse(CTSValidation.cpfIsValid("28309200405"))
    }

    @Test
    fun testCPFWithInvalidLength() {
        assertFalse(CTSValidation.cpfIsValid("2830920040"))
    }

    @Test
    fun testCPFInvalidCPFRepetedNumbers() {
        assertFalse(CTSValidation.cpfIsValid("11111111111"))
    }

    //--------------------------------------------------------------------------------
    // Tests for validation of CNPJ
    //--------------------------------------------------------------------------------
    @Test
    fun testCNPJValid() {
        assertTrue(CTSValidation.cnpjIsValid("22871777000164"))
    }

    @Test
    fun testCNPJInvalid() {
        assertFalse(CTSValidation.cnpjIsValid("22871777000165"))
    }

    @Test
    fun testCNPJWithInvalidLength() {
        assertFalse(CTSValidation.cnpjIsValid("2287177700016"))
    }

    @Test
    fun testCNPJInvalidCNPJRepetedNumbers() {
        assertFalse(CTSValidation.cnpjIsValid("11111111111111"))
    }

}
