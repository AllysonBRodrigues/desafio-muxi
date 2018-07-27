package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.maneger

import retrofit2.Callback
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.BuildConfig
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.`interface`.FruitsInteface
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.repository.FruitsRepository
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.retrofit.RetrofitService
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruits

class FruitsManeger(val url: String): FruitsRepository {


    override fun request(callback: Callback<Fruits>) {
        RetrofitService().getService(FruitsInteface::class.java, BuildConfig.API_HOST).getFruits(url).enqueue(callback)
    }
}