package br.com.novoprojeto.applogin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.novoprojeto.applogin.R
import br.com.novoprojeto.applogin.adapter.MuralAdapter.MuralViewHolder
import br.com.novoprojeto.applogin.model.Mural

class MuralAdapter (val mural: List<Mural>) : RecyclerView.Adapter<MuralAdapter.MuralViewHolder>() {

    class MuralViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nome : TextView = itemView.findViewById(R.id.txtMural)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MuralViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mural, parent, false)
        return br.com.novoprojeto.applogin.adapter.MuralAdapter.MuralViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MuralViewHolder,
        position: Int
    ) {
        var mural = mural[position]
        holder.nome.text = mural.text
    }

    override fun getItemCount(): Int {
        return mural.size
    }

}