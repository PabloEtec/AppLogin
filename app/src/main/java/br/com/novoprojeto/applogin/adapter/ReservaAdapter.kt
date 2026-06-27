package br.com.novoprojeto.applogin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.novoprojeto.applogin.R
import br.com.novoprojeto.applogin.model.Reserva

class ReservaAdapter(val reserva: List<Reserva>) : RecyclerView.Adapter<ReservaAdapter.ReservaViewHolder>() {

        class ReservaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            val nome : TextView = itemView.findViewById(R.id.txtReserva)
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ReservaViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reserva, parent, false)
            return br.com.novoprojeto.applogin.adapter.ReservaAdapter.ReservaViewHolder(view)
        }

        override fun onBindViewHolder(
            holder: ReservaViewHolder,
            position: Int
        ) {
            var reserva = reserva[position]
            holder.nome.text = reserva.title
        }

        override fun getItemCount(): Int {
            return reserva.size
        }
    
}