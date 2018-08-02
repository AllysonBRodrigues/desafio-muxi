package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.view.view_holder

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_fruit.view.*
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.listerners.ItemClickListener

class FruitsViewHolder(view: View, itemClickListener: ItemClickListener): RecyclerView.ViewHolder(view)  {

    var name: AppCompatTextView = view.name
    var price: AppCompatTextView = view.price
    var image: AppCompatImageView = view.image

    init {
        view.setOnClickListener {
            itemClickListener.itemClick(adapterPosition)
        }
    }

}