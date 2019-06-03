package com.lovato.parcial1_pdm.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lovato.parcial1_pdm.R
import com.lovato.parcial1_pdm.RoomDatabase.Entities.MatchEntity
import kotlinx.android.synthetic.main.match_cardview.view.*

class MatchAdapter( var items : List<MatchEntity>, val clickListener : (MatchEntity) -> Unit) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.match_cardview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], clickListener)
    }


    fun dataChange(lista_books : List<MatchEntity>){
        items = lista_books
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: MatchEntity,clickListener: (MatchEntity) -> Unit) = with(itemView) {
            tv_vs.text = "${item.nameTeamA} VS ${item.nameTeamB}"
            this.setOnClickListener{clickListener(item)}
        }
    }
}