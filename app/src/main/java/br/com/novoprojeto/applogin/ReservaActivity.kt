package br.com.novoprojeto.applogin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.novoprojeto.applogin.adapter.ReservaAdapter
import br.com.novoprojeto.applogin.model.Reserva

class ReservaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reserva)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbarReserva = findViewById<Toolbar>(R.id.toolbarReserva)
        setSupportActionBar(toolbarReserva)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rc2 = findViewById<RecyclerView>(R.id.RecyclerReserva)
        rc2.layoutManager = LinearLayoutManager(this)
        val reservas = listOf(
            Reserva(1, "Academia"),
            Reserva(2, "Brinquedoteca"),
            Reserva(3, "Churrasqueira"),
            Reserva(4, "Salão de Festas"),
            Reserva(5, "Salão de Jogos")
        )

        rc2.adapter = ReservaAdapter(reservas)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Volta para a tela anterior
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}