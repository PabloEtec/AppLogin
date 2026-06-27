package br.com.novoprojeto.applogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttBoleto = findViewById<Button>(R.id.buttBoleto)
        buttBoleto.setOnClickListener {
            val intent = Intent(this, BoletoActivity::class.java)
            startActivity(intent)
        }

        val buttReserva = findViewById<Button>(R.id.buttReserva)
        buttReserva.setOnClickListener {
            val intent = Intent(this, ReservaActivity::class.java)
            startActivity(intent)
        }

        val buttAutorização = findViewById<Button>(R.id.buttAutorização)
        buttAutorização.setOnClickListener {
            val intent = Intent(this, AutorizacaoActivity::class.java)
            startActivity(intent)
        }

        val buttMural = findViewById<Button>(R.id.buttMural)
        buttMural.setOnClickListener {
            val intent = Intent(this, MuralActivity::class.java)
            startActivity(intent)
        }

        val buttPreConta = findViewById<Button>(R.id.buttPreConta)
        buttPreConta.setOnClickListener {
            val intent = Intent(this, ContasActivity::class.java)
            startActivity(intent)
        }


        val buttMudanças = findViewById<Button>(R.id.buttMudanças)
        buttMudanças.setOnClickListener {
            val intent = Intent(this, MudancaActivity::class.java)
            startActivity(intent)
        }

        val buttPortaria = findViewById<Button>(R.id.buttPortaria)
        buttPortaria.setOnClickListener {
            val intent = Intent(this, PortariaActivity::class.java)
            startActivity(intent)
        }

    }
}