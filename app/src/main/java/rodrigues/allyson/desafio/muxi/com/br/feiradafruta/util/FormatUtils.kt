package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util

import java.text.DecimalFormat

class FormatUtils {

    fun formatDolar(price: Double): String{

        val format = DecimalFormat("#0.00")
        return "$ ${format.format(price)}"

    }

    fun formatReal(price: Double): String{

        val format = DecimalFormat("#0.00")
        return "R$ ${format.format(price)}"

    }


}