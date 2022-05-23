/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.extenso

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CTSExtensoMoedaTest {

    @Test
    fun valorPorExtensoValidoNumeroInteiro() {
        assertEquals("dez reais", CTSExtensoMoeda.valorPorExtenso("10"))
    }

    @Test
    fun valorPorExtensoValidoNumeroFracionario() {
        assertEquals("dez reais", CTSExtensoMoeda.valorPorExtenso("10.00"))
    }

    @Test
    fun valorPorExtensoValidoNumeroFracionarioCentavo() {
        assertEquals("um mil setecentos e cinquenta reais e um centavo", CTSExtensoMoeda.valorPorExtenso("1750.1"))
    }

    @Test
    fun valorPorExtensoValidoNumeroFracionarioCentavos() {
        assertEquals("um mil setecentos e cinquenta reais e quarenta centavos", CTSExtensoMoeda.valorPorExtenso("1750.40"))
    }

    @Test
    fun valorPorExtensoInvalidoValorVazio() {
        assertEquals("valor inválido", CTSExtensoMoeda.valorPorExtenso(""))
    }

}