package br.com.novoprojeto.applogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.novoprojeto.applogin.adapter.MuralAdapter
import br.com.novoprojeto.applogin.adapter.ReservaAdapter
import br.com.novoprojeto.applogin.model.Mural
import br.com.novoprojeto.applogin.model.Reserva

class MuralActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mural)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbarMural = findViewById<Toolbar>(R.id.toolbarMural)
        setSupportActionBar(toolbarMural)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rc2 = findViewById<RecyclerView>(R.id.RecyclerMural)
        rc2.layoutManager = LinearLayoutManager(this)
        val murales = listOf(
            Mural(1, "Novo Bicicletário"),
            Mural(2, "Portão de Veículos"),
            Mural(3, "Alarme do Edifício"),
            Mural(4, "Festa Junina"),
        )

        rc2.adapter = MuralAdapter(murales)

        val ButtVoltarMural = findViewById<Button>(R.id.ButtVoltarMural)
        ButtVoltarMural.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}