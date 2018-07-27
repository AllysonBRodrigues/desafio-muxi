package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.interfaces

import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.repository.FruitsRepository

interface Presenter {

    fun bind(view: View, repository: FruitsRepository)

    fun request()

}