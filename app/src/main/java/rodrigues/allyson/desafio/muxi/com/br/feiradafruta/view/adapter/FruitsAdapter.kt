package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.R
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.listerners.ItemClickListener
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruit
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util.FormatUtils
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util.StringUtils
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.view.view_holder.FruitsViewHolder

class FruitsAdapter(val context: Context, val listFruits: MutableList<Fruit>, val itemClickListener: ItemClickListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_fruit, parent, false)
        return FruitsViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int {
        return listFruits.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as FruitsViewHolder).name.text = StringUtils().upcaseFirstChar(listFruits[position].name)
        holder.price.text = FormatUtils().formatDolar(listFruits[position].price)

        if(listFruits[position].image.isNotEmpty()){
            Picasso.get()
                    .load(listFruits[position].image)
                    .placeholder(R.drawable.placeholder)
                    .fit()
                    .into(holder.image)
        }

    }
}