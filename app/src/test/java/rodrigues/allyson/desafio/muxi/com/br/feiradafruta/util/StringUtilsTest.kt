package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util

import org.junit.Test

import org.junit.Assert.*

class StringUtilsTest {

    private var stringUtils = StringUtils()
    private var string = "apple"

    @Test
    fun upcaseFirstChar() {
        assertEquals("Apple", stringUtils.upcaseFirstChar(string))
        assertNotEquals("apple", stringUtils.upcaseFirstChar(string))
    }
}