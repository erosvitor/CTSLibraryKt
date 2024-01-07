/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.extenso

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CTSExtensoDataTest {

    //--------------------------------------------------------------------------------
    // Testes para validar dia da semana por extenso
    //--------------------------------------------------------------------------------
    @Test
    fun testDiaSemanaValido() {
        assertEquals("segunda", CTSExtensoData.nomeDoDiaDaSemana(1))
    }

    @Test
    fun testDiaSemanaInvalido() {
        assertEquals("dia semana inválido", CTSExtensoData.nomeDoDiaDaSemana(8))
    }

    @Test
    fun testDiaSemanaCompletoValido() {
        assertEquals("segunda-feira", CTSExtensoData.nomeDoDiaDaSemanaCompleto(1))
    }

    @Test
    fun testDiaSemanaCompletoInvalido() {
        assertEquals("dia semana inválido", CTSExtensoData.nomeDoDiaDaSemanaCompleto(8))
    }

    //--------------------------------------------------------------------------------
    // Testes para validar dia do mês por extenso
    //--------------------------------------------------------------------------------
    @Test
    fun testMesPorExtensoValido() {
        assertEquals("outubro", CTSExtensoData.nomeDoMes(10))
    }

    @Test
    fun testMesPorExtensoInvalido() {
        assertEquals("mês inválido", CTSExtensoData.nomeDoMes(0))
    }

    @Test
    fun testMesPorExtensoValidoPorData() {
        assertEquals("outubro", CTSExtensoData.nomeDoMes("10/10/2010"))
    }

    @Test
    fun testMesPorExtensoInvalidoPorData() {
        assertEquals("mês inválido", CTSExtensoData.nomeDoMes("10/20/2010"))
    }

    @Test
    fun testMesPorExtensoInvalidoPorDataIncompleta() {
        assertEquals("mês inválido", CTSExtensoData.nomeDoMes("10/10/20"))
    }

    //--------------------------------------------------------------------------------
    // Testes para validar data por extenso
    //--------------------------------------------------------------------------------
    @Test
    fun testDataPorExtensoDataValida() {
        assertEquals("10 de outubro de 2010", CTSExtensoData.dataPorExtenso("10/10/2010"))
    }

    @Test
    fun testDataPorExtensoDataInvalida() {
        assertEquals("data inválida", CTSExtensoData.dataPorExtenso("10/20/2010"))
    }

    @Test
    fun testDataPorExtensoDataIncompleta() {
        assertEquals("data inválida", CTSExtensoData.dataPorExtenso("10/20/20"))
    }

    @Test
    fun testDataPorExtensoDataVazia() {
        assertEquals("data inválida", CTSExtensoData.dataPorExtenso(""))
    }

}