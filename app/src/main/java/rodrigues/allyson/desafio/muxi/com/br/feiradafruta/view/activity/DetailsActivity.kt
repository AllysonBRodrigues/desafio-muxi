package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.R
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruit
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util.Constants
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util.FormatUtils
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util.StringUtils


class DetailsActivity : AppCompatActivity() {

    private lateinit var fruit: Fruit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        fruit = Gson().fromJson(intent.getStringExtra(Constants.Params.FRUIT_DETAIL), Fruit::class.java)
        buildScreen()

    }

    private fun buildScreen() {
        if (fruit.image.isNotEmpty()) {
            Picasso.get()
                    .load(fruit.image)
                    .fit()
                    .into(image)
        }
        name.text = StringUtils().upcaseFirstChar(fruit.name)
        price.text = FormatUtils().formatDolar(fruit.price)
        real_price.text = FormatUtils().formatReal(fruit.price * 3.5)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState!!.putString(Constants.Params.FRUIT_DETAIL, Gson().toJson(this.fruit))
        super.onSaveInstanceState(outState)
    }

}
