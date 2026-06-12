package br.com.novoprojeto.applogin

import android.content.Intent
import android.icu.text.ListFormatter
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.novoprojeto.applogin.adapter.BoletoAdapter
import br.com.novoprojeto.applogin.model.Boleto

class BoletoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boleto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbarBoleto = findViewById<Toolbar>(R.id.toolbarBoleto)
        setSupportActionBar(toolbarBoleto)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rc = findViewById<RecyclerView>(R.id.recyclerBoleto)
        rc.layoutManager = LinearLayoutManager(this)
        val boletos = listOf(
            Boleto(1,"Condomínio de Junho", 1000.00, "30/06/2026"),
            Boleto(2,"Multa", 100.00, "30/06/2002"),
            Boleto(3,"Obra do Prédio", 9753.00, "30/06/2067"),
            Boleto(4,"Obra do Elevador", 9753.00, "30/06/2067"),
            Boleto(5,"Condomínio Agosto", 9753.00, "30/06/2025"),
        )

        rc.adapter = BoletoAdapter(boletos)

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