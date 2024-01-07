/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.formatting

/**
 * The CTSFormatting class provide resources to format name,
 * document numbers and much others.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
object CTSFormatting {

    fun formatPersonalName(name: String): String {
        var str = name[0].toString().uppercase()
        var i = 1
        while (i < name.length) {
            if (name[i] == ' ') {
                i++
                str += ' '
                str += name[i].uppercase()
            }
            else {
                str += name[i].lowercase()
            }
            i++
        }
        return str
    }

    /**
     * Retira caracteres de formatação do CPF.
     *
     * @param cpf CPF
     * @return O CPF sem formatação
     */
    fun cpfRetirarFormatacao(cpf: String): String {
        val cpfSemFormatacao = StringBuilder()
        for (i in cpf.indices) {
            if (Character.isDigit(cpf[i])) {
                cpfSemFormatacao.append(cpf[i])
            }
        }
        return cpfSemFormatacao.toString()
    }

    /**
     * Formata o CPF.
     *
     * @param cpf CPF
     * @return O CPF formatado
     */
    fun cpfAplicarFormatacao(cpf: String): String {
        val temp = cpfRetirarFormatacao(cpf)
        return if (temp.length != 11) {
            cpf
        } else {
            temp.substring(0, 3) + "." + temp.substring(3, 6) + "." + temp.substring(6, 9) + "-" + temp.substring(9, 11)
        }
    }

    /**
     * Retira caracteres de formatação do CNPJ.
     *
     * @param cnpj CNPJ
     * @return O CNPJ sem formatação
     */
    fun cnpjRetirarFormatacao(cnpj: String): String {
        val cnpjSemFormatacao = StringBuilder()
        for (i in cnpj.indices) {
            if (Character.isDigit(cnpj[i])) {
                cnpjSemFormatacao.append(cnpj[i])
            }
        }
        return cnpjSemFormatacao.toString()
    }

    /**
     * Formata o CNPJ.
     *
     * @param cnpj CNPJ
     * @return O CNPJ formatado
     */
    fun cnpjAplicarFormatacao(cnpj: String): String {
        val temp = cnpjRetirarFormatacao(cnpj)
        return if (temp.length != 14) {
            cnpj
        } else {
            temp.substring(0, 2) + "." + temp.substring(2, 5) + "." + temp.substring(5, 8) + "/" + temp.substring(8, 12) + "-" + temp.substring(12, 14)
        }
    }

}