package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util

class StringUtils {

    fun upcaseFirstChar(string: String): String{

        return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase()

    }

}