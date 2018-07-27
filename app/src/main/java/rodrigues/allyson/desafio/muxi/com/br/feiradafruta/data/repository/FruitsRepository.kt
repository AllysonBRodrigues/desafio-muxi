package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.repository
import retrofit2.Callback
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruits

interface FruitsRepository {

    fun request(callback: Callback<Fruits>)

}