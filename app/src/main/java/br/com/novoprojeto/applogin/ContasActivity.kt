package br.com.novoprojeto.applogin

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.novoprojeto.applogin.adapter.BoletoAdapter
import br.com.novoprojeto.applogin.adapter.ContasAdapter
import br.com.novoprojeto.applogin.model.Boleto
import br.com.novoprojeto.applogin.model.Contas

class ContasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbarContas = findViewById<Toolbar>(R.id.toolbarContas)
        setSupportActionBar(toolbarContas)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rc = findViewById<RecyclerView>(R.id.recyclerContas)
        rc.layoutManager = LinearLayoutManager(this)
        val contas = listOf(
            Contas(1,"Compra de material", "02/05/2026", 500.00),
            Contas(2,"Mensalidade de condominio", "05/05/2026", 1500.00),
            Contas(3,"Manutenção elevador", "10/05/2026", 1200.00),
        )

        rc.adapter = ContasAdapter(contas)
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