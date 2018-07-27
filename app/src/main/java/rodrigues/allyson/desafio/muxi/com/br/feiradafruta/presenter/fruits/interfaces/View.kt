package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.interfaces

import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruits

interface View {

    fun start()

    fun sucess(fruits: Fruits)

    fun erro(errorMessage: String)

}