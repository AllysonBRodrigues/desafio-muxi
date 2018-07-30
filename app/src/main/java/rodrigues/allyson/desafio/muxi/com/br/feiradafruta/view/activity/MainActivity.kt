package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.R
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.maneger.FruitsManeger
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.listerners.ItemClickListener
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruit
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruits
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.interfaces.Presenter
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.interfaces.View
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.presenter.FruitsPresenter
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util.Constants
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.view.adapter.FruitsAdapter


class MainActivity : AppCompatActivity(), View, ItemClickListener {



    private lateinit var presenter: Presenter
    private var listFruits = mutableListOf<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            val listType = object : TypeToken<MutableList<Fruit>>(){}.type
            this.listFruits = Gson().fromJson(savedInstanceState.getString(Constants.Params.FRUITS_LIST), listType)
            createList()
        }else{
            start()
        }
    }


    override fun start() {
        presenter = FruitsPresenter()
        presenter.bind(this, FruitsManeger("desafio-android/master/fruits.json"))
        presenter.request()
    }

    override fun sucess(fruits: Fruits) {
        this.listFruits = fruits.fruits
        createList()
    }

    private fun createList() {
        val layoutManager = LinearLayoutManager(this)

        list_fruits.setLayoutManager(layoutManager)
        val adapter = FruitsAdapter(this, this.listFruits, this)
        list_fruits.setAdapter(adapter)

        list_fruits.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun erro(errorMessage: String) {

    }

    override fun itemClick(position: Int) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(Constants.Params.FRUIT_DETAIL, Gson().toJson(this.listFruits[position]))
        startActivity(intent)
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        outState!!.putString(Constants.Params.FRUITS_LIST, Gson().toJson(this.listFruits))
        super.onSaveInstanceState(outState)
    }



}
