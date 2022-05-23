/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.validation

import br.com.ctseducare.date.CTSDate

/**
 * The CTSValidation class provide resources to validate names,
 * emails, dates, telephones numbers, zip codes and much others.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
object CTSValidation {

    private const val PATTERN_PERSONAL_NAME = "^[a-zA-ZáàâãéèêíïóôõöúçÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇ ]+$"
    private const val PATTERN_EMAIL = "^[-\\da-zA-Z.+_]+@[-\\da-zA-Z.+_]+\\.[a-zA-Z]{2,4}$"
    private const val PATTERN_DATE_BRAZIL = "^(\\d|[0-2]\\d|3[0-1])/(\\d|0\\d|1[0-2])/\\d{4}$"

    /**
     * Checks if a personal name is valid.
     *
     * @param name Personal name
     * @return The value 'true' for a valid name or 'false' otherwise
     */
    fun personalNameIsValid(name: String) = name.matches(PATTERN_PERSONAL_NAME.toRegex())

    /**
     * Checks if an email is valid.
     *
     * @param email Email
     * @return The value 'true' for a valid email or 'false' otherwise
     */
    fun emailIsValid(email: String) = email.matches(PATTERN_EMAIL.toRegex())

    /**
     * Checks if a date is valid.
     *
     * @param date Date
     * @return The value 'true' for a valid date or 'false' otherwise
     */
    fun dateIsValid(date: String) = date.matches(PATTERN_DATE_BRAZIL.toRegex())

    /**
     * Checks if a year is leap year.
     *
     * @param date Date
     * @return The value 'true' for a leap year or 'false' otherwise
     */
    fun isLeapYear(date: String): Boolean {
        val year = CTSDate.getYear(date)

        return (((year % 4) == 0) && (((year % 400) == 0) || ((year % 100) != 0)))
    }

    /**
     * Checks if a CPF is valid.
     *
     * @param cpf CPF
     * @return The value 'true' for a valid CPF or 'false' otherwise
     */
    fun cpfIsValid(cpf: String): Boolean {
        if (cpf.trim().length != 11) {
            return false
        }

        if (cpf == "00000000000" ||
            cpf == "11111111111" ||
            cpf == "22222222222" ||
            cpf == "33333333333" ||
            cpf == "44444444444" ||
            cpf == "55555555555" ||
            cpf == "66666666666" ||
            cpf == "77777777777" ||
            cpf == "88888888888" ||
            cpf == "99999999999"
        ) {
            return false
        }

        val pesos = intArrayOf(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)
        var soma = 0
        var digito: Int

        // Calcula e valida o primeiro digito verificador
        for (i in 0..8) {
            soma += Integer.parseInt(cpf[i].toString()) * pesos[i + 1]
        }
        var resto: Int = soma % 11
        digito = 11 - resto
        if (digito == 11 || digito == 10) {
            digito = 0
        }
        if (digito != Integer.parseInt(cpf[9].toString())) {
            return false
        }

        // Calcula e valida o segundo digito verificador
        soma = 0
        for (i in 0..9) {
            soma += Integer.parseInt(cpf[i].toString()) * pesos[i]
        }
        resto = soma % 11
        digito = 11 - resto
        if (digito == 11 || digito == 10) {
            digito = 0
        }

        return digito == Integer.parseInt(cpf[10].toString())
    }

    /**
     * Checks if a CNPJ is valid.
     *
     * @param cnpj CNPJ
     * @return The value 'true' for a valid CNPJ or 'false' otherwise
     */
    fun cnpjIsValid(cnpj: String): Boolean {
        if (cnpj.trim().length != 14) {
            return false
        }

        if (cnpj == "00000000000000" ||
            cnpj == "11111111111111" ||
            cnpj == "22222222222222" ||
            cnpj == "33333333333333" ||
            cnpj == "44444444444444" ||
            cnpj == "55555555555555" ||
            cnpj == "66666666666666" ||
            cnpj == "77777777777777" ||
            cnpj == "88888888888888" ||
            cnpj == "99999999999999"
        ) {
            return false
        }

        val pesos = intArrayOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
        var soma = 0
        var digito: Int

        // Calcula e valida o primeiro digito verificador
        for (i in 0..11) {
            soma += Integer.parseInt(cnpj[i].toString()) * pesos[i + 1]
        }
        var resto: Int = soma % 11
        digito = 11 - resto
        if (digito == 11 || digito == 10) {
            digito = 0
        }
        if (digito != Integer.parseInt(cnpj[12].toString())) {
            return false
        }

        // Calcula e valida o segundo digito verificador
        soma = 0
        for (i in 0..12) {
            soma += Integer.parseInt(cnpj[i].toString()) * pesos[i]
        }
        resto = soma % 11
        digito = 11 - resto
        if (digito == 11 || digito == 10) {
            digito = 0
        }
        return digito == Integer.parseInt(cnpj[13].toString())
    }

}