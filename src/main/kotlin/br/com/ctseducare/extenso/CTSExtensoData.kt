/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.extenso

import br.com.ctseducare.date.CTSDate
import br.com.ctseducare.validation.CTSValidation

/**
 * A classe CTSExtensoData fornece recursos para converter uma
 * data, ou partes de uma data, em uma representação por extenso.
 *
 * Por exemplo, a data 10/10/2010 é convertida para 10 de outubro de 2010.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
object CTSExtensoData {

    private val DIAS_SEMANA = arrayOf("segunda", "terça", "quarta", "quinta", "sexta", "sábado", "domingo")

    private val DIAS_SEMANA_LONGO = arrayOf("segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado", "domingo")

    private val MESES = arrayOf("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro")

    /**
     * Retornar o nome do dia da semana.
     *
     * @param dia Número do dia da semana
     * @return O nome do dia da semana
     */
    fun nomeDoDiaDaSemana(dia: Int): String {
        return if (dia < 1 || dia > 7) {
            "dia semana inválido"
        } else {
            DIAS_SEMANA[dia-1]
        }
    }

    /**
     * Retornar o nome completo do dia da semana.
     *
     * @param dia Número do dia da semana
     * @return O nome completo do dia da semana
     */
    fun nomeDoDiaDaSemanaCompleto(dia: Int): String {
        return if (dia < 1 || dia > 7) {
            "dia semana inválido"
        } else {
            DIAS_SEMANA_LONGO[dia-1]
        }
    }

    /**
     * Retornar o nome do mês.
     *
     * @param mes Número do mês
     * @return O nome do mês
     */
    fun nomeDoMes(mes: Int): String {
        return if (mes < 1 || mes > 12) {
            "mês inválido"
        } else {
            MESES[mes-1]
        }
    }

    /**
     * Retornar o nome do mês.
     *
     * @param data Data para extrair o número do mês
     * @return O nome do mês
     */
    fun nomeDoMes(data: String): String {
        return if (!CTSValidation.dateIsValid(data)) {
            "mês inválido"
        } else {
            nomeDoMes(CTSDate.getMonth(data))
        }
    }

    /**
     * Retornar a data por extenso.
     *
     * @param data Data para gerar a data por extenso
     * @return A data por extenso
     */
    fun dataPorExtenso(data: String): String {
        return if (!CTSValidation.dateIsValid(data)) {
            "data inválida"
        } else {
            "%d de %s de %d".format(CTSDate.getDay(data), nomeDoMes(data), CTSDate.getYear(data))
        }
    }

}