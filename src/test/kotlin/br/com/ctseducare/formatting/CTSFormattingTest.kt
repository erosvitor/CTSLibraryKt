/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.formatting

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CTSFormattingTest {

    //--------------------------------------------------------------------------------
    // Tests for formatting personal name
    //--------------------------------------------------------------------------------
    @Test
    fun formatCorrectPersonalName() {
        assertEquals("Eros Vitor", CTSFormatting.formatPersonalName("EROS vitor"))
    }

    //--------------------------------------------------------------------------------
    // Tests for formatting CPF
    //--------------------------------------------------------------------------------
    @Test
    fun retirarformatacaoCPFCorreto() {
        assertEquals("01790227925", CTSFormatting.cpfRetirarFormatacao("017.902.279-25"))
    }

    @Test
    fun formatarCPFCorreto() {
        assertEquals("017.902.279-25", CTSFormatting.cpfAplicarFormatacao("017902279-25"))
    }

    @Test
    fun formatarCPFIncorreto() {
        assertEquals("017902279-2", CTSFormatting.cpfAplicarFormatacao("017902279-2"))
    }

    //--------------------------------------------------------------------------------
    // Tests for formatting CNPJ
    //--------------------------------------------------------------------------------
    @Test
    fun retirarformatacaoCNPJCorreto() {
        assertEquals("08823013000172", CTSFormatting.cnpjRetirarFormatacao("08.823.013/0001-72"))
    }

    @Test
    fun formatarCNPJCorreto() {
        assertEquals("08.823.013/0001-72", CTSFormatting.cnpjAplicarFormatacao("08823013/0001-72"))
    }

    @Test
    fun formatarCNPJIncorreto() {
        assertEquals("08823013/0001-7", CTSFormatting.cnpjAplicarFormatacao("08823013/0001-7"))
    }

}