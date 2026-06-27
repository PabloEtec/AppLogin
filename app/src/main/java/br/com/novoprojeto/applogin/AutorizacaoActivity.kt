package br.com.novoprojeto.applogin

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AutorizacaoActivity : AppCompatActivity() {

    private var dataSelecionada: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_autorizacao)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configuração da Toolbar para habilitar o botão de voltar
        val toolbar = findViewById<Toolbar>(R.id.toolbarAutorizacao)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Inicialização dos campos do layout
        val editNome = findViewById<EditText>(R.id.editTextNome)
        val editCPF = findViewById<EditText>(R.id.editTextCPF)
        val editApto = findViewById<EditText>(R.id.editTextApto)
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val btnSalvar = findViewById<Button>(R.id.button)

        // --- MELHORIA: Impede seleção de datas passadas ---
        // Define o tempo mínimo como o momento atual (menos 1 segundo para evitar conflitos)
        calendarView.minDate = System.currentTimeMillis() - 1000

        // Inicializa a dataSelecionada com a data de hoje por padrão
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        dataSelecionada = sdf.format(calendarView.date)

        // Captura a data quando o usuário clica no calendário
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // O mês no CalendarView vai de 0 a 11, por isso somamos 1
            dataSelecionada = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year)
        }

        // Lógica do botão Salvar (Movida para fora do calendário)
        btnSalvar.setOnClickListener {
            val nome = editNome.text.toString().trim()
            val cpf = editCPF.text.toString().trim()
            val apto = editApto.text.toString().trim()

            // Verificação se os campos estão vazios
            if (nome.isEmpty() || cpf.isEmpty() || apto.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show()
            } else {
                // Toast de Sucesso
                val resumo = "Autorizado: $nome\nData: $dataSelecionada"
                Toast.makeText(this, "Sucesso!\n$resumo", Toast.LENGTH_LONG).show()

                // Opcional: Limpar campos ou fechar a Activity
                // finish()
            }
        }
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
