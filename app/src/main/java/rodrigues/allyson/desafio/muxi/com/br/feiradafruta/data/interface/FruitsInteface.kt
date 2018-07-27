package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.`interface`

import retrofit2.http.GET
import retrofit2.http.Path
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruits

interface FruitsInteface {

    @GET("{url}")
    fun getFruits(@Path("url") url: String): retrofit2.Call<Fruits>

}