package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private fun retrofitBuilder(url: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
    }

    fun <T> getService(tClass: Class<T>, url: String): T {
        return retrofitBuilder(url).create(tClass)
    }

}