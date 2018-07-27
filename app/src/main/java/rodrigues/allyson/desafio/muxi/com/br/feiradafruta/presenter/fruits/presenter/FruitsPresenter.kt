package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.presenter


import retrofit2.Call
import retrofit2.Response
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.repository.FruitsRepository
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruits
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.interfaces.Presenter
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.interfaces.View

class FruitsPresenter: Presenter {


    lateinit var view: View
    lateinit var repository: FruitsRepository

    override fun bind(view: View, repository: FruitsRepository) {
        this.view = view
        this.repository = repository
    }

    override fun request() {
        repository.request(object : retrofit2.Callback<Fruits>{
            override fun onFailure(call: Call<Fruits>?, t: Throwable?) {
                view.erro(t!!.message.toString())
            }

            override fun onResponse(call: Call<Fruits>?, response: Response<Fruits>?) {
                if(response!!.code() == 200){
                    view.sucess(response.body()!!)
                }else{
                    view.erro(response.errorBody().toString())
                }
            }
        })
    }
}