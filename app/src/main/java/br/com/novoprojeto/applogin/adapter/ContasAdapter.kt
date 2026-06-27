package br.com.novoprojeto.applogin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.novoprojeto.applogin.R
import br.com.novoprojeto.applogin.model.Contas

class ContasAdapter (val contas: List<Contas>) : RecyclerView.Adapter<ContasAdapter.ContasViewHolder>() {

    class ContasViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nome : TextView = itemView.findViewById(R.id.txtTituloConta)
        val date : TextView = itemView.findViewById(R.id.txtDate)
        val valor : TextView = itemView.findViewById(R.id.txtValorConta)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contas, parent, false)
        return ContasAdapter.ContasViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ContasViewHolder,
        position: Int
    ) {
        var contas = contas[position]
        holder.nome.text = contas.contaNome
        holder.date.text = contas.date
        holder.valor.text = contas.valor.toString()
    }

    override fun getItemCount(): Int {
        return contas.size
    }

}