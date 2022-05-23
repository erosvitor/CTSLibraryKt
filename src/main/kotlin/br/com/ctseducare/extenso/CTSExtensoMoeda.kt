/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.extenso

/**
 * A classe CTSExtensoMoeda fornece recursos para converter um
 * valor monetário por extenso.
 *
 * Por exemplo, o valor 1.500,00 é convertido para Um mil e quinhentos reais.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
object CTSExtensoMoeda {
    private const val SINGULAR = 0
    private const val PLURAL = 1

    private val unidades = arrayOf("", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove",
        "dez", "onze", "doze", "treze", "quatorze", "quinze", "dessesseis", "dezessete", "dezoito", "dezenove")
    private val dezenas = arrayOf("", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta",
        "oitenta", "noventa")
    private val centenas = arrayOf("", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos",
        "setecentos", "oitocentos", "novecentos")
    private val milhares = arrayOf( arrayOf("", ""), arrayOf("", ""), arrayOf("mil", "mil"), arrayOf("milhão", "milhões"),
        arrayOf("bilhão", "bilhões"), arrayOf("trilhão", "trilhões") )

    /**
     * Retornar o valor monetário por extenso.
     *
     * @param valor Valor monetário a ser convertido em extenso
     * @return O extenso do valor monetário
     */
    fun valorPorExtenso(valor: String): String {
        if (valor.trim().isEmpty()) {
            return "valor inválido"
        }

        val casasDecimais: String
        val numeroTmp: String
        val centenas = mutableListOf<String>()
        var inteiroPorExtenso = ""
        var decimalPorExtenso = ""

        // --------------------------------------------------------------------------------
        // Calcula o extenso da parte decimal, se houver.
        val posVirgula: Int = valor.indexOf('.')
        if (posVirgula > 0) {
            casasDecimais = valor.substring(posVirgula + 1)
            decimalPorExtenso = centenaPorExtenso(Integer.parseInt(casasDecimais))
            if (Integer.parseInt(casasDecimais) == 0)
                decimalPorExtenso = ""
            else if (Integer.parseInt(casasDecimais) == 1)
                decimalPorExtenso += " centavo"
            else
                decimalPorExtenso += " centavos"
            numeroTmp = valor.substring(0, posVirgula)
        } else
            numeroTmp = valor

        // --------------------------------------------------------------------------------
        // Calcula o extenso da parte inteira.
        // Verifica quantas centenas cheias existem (Ex. O número 1500300 tem duas centenas cheias)
        val totalCentenasCheias = numeroTmp.length / 3

        // Verifica as posições para pegar a centena incompleta, se
        // houver (Ex. O número 1500300 tem como centena incompleta o 1)
        var posicaoInicial = 0
        var posicaoFinal = numeroTmp.length - (totalCentenasCheias * 3)

        // Cria variável para guardar o índice das medidas...

        // Verifica se existe centena incompleta...
        var indiceMilhar: Int = if (posicaoInicial != posicaoFinal) {
            // Havendo centena incompleta, pega ela e adiciona na lista de centenas...
            centenas.add(numeroTmp.substring(posicaoInicial, posicaoFinal))
            totalCentenasCheias + 1
        } else {
            totalCentenasCheias
        }

        // Pega as posições da primeira centena cheia...
        posicaoInicial += posicaoFinal
        posicaoFinal += 3

        // Adiciona a centena cheia na lista e busco as demais centenas, se houverem...
        for (i in 1..totalCentenasCheias) {
            centenas.add(numeroTmp.substring(posicaoInicial, posicaoFinal))
            posicaoInicial += 3
            posicaoFinal += 3
        }

        // Calcula o extenso de cada centena...
        var indiceColuna: Int
        for (i in centenas.indices) {
            if (centenas[i] != "000") {
                indiceColuna = if (centenas.get(i).toInt() == 1) SINGULAR else PLURAL
                inteiroPorExtenso += " " + centenaPorExtenso(Integer.parseInt(centenas.get(i))) + " " + milhares[indiceMilhar][indiceColuna]
            }
            indiceMilhar--
        }

        inteiroPorExtenso = if ((totalCentenasCheias == 0) && (centenas.get(0) == "1"))
            inteiroPorExtenso.trim() + " real"
        else
            inteiroPorExtenso.trim() + " reais"

        return if (decimalPorExtenso == "")
            inteiroPorExtenso
        else
            "$inteiroPorExtenso e $decimalPorExtenso"
    }

    /**
     * Retorna a centena por extenso.
     *
     * @param numero Número representando a centena
     * @return A centena por extenso
     */
    private fun centenaPorExtenso(numero: Int): String {
        val numeroString = numero.toString()

        if (numero < 20) {
            return unidades[numero]
        } else if (numero < 100) {
            val dezena = numeroString.substring(0, 1).toInt()
            val unidade = numeroString.substring(1, 2).toInt()
            return dezenas[dezena] + (if (unidade == 0) "" else " e " + unidades[unidade])
        } else if (numero < 1000) {
            val centena = numeroString.substring(0, 1).toInt()
            val dezena = numeroString.substring(1, 2).toInt()
            val unidade = numeroString.substring(2, 3).toInt()
            return if ((centena == 1) && ((dezena > 0) || (unidade > 0))) {
                "cento" + (if (dezena == 0) "" else " e " + dezenas[dezena]) + (if (unidade == 0) "" else " e " + unidades[unidade])
            } else {
                centenas[centena] + (if (dezena == 0) "" else " e " + dezenas[dezena]) + (if (unidade == 0) "" else " e " + unidades[unidade])
            }
        } else {
            return ""
        }
    }
}