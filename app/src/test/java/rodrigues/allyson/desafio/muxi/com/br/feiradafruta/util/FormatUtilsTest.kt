package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util

import org.junit.Test

import org.junit.Assert.*

class FormatUtilsTest {

    private var formatUtils = FormatUtils()
    private var value = 100.toDouble()

    @Test
    fun formatDolar() {

        assertEquals("$ 100,00", formatUtils.formatDolar(value))

    }

    @Test
    fun formatReal() {
        assertEquals("R$ 100,00", formatUtils.formatReal(value))
    }
}