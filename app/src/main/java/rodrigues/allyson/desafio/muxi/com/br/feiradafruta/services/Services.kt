package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.services

import android.os.AsyncTask
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Services(val valueInterface: ConvertValueInterface){

    fun convert(value: Double){

        doAsync {
            uiThread {
                valueInterface.valueConvert(value * 3.5)
            }

        }

    }


}