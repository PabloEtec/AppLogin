package br.com.novoprojeto.applogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.novoprojeto.applogin.model.Login
import br.com.novoprojeto.applogin.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val apiService = ApiClient.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttLogin = findViewById<Button>(R.id.ButtLogin)
        buttLogin.setOnClickListener {

            val email = findViewById<EditText>(R.id.editTextTextEmailLogin).text.toString()
            val senha = findViewById<EditText>(R.id.editTextPasswordLogin).text.toString()

            // ✅ CORREÇÃO 1: intent criado aqui (fora do callback), com nome minúsculo
            val intent = Intent(this, HomeActivity::class.java)
            val login = Login(email = email, senha = senha)

            apiService.autenticar(login).enqueue(object : Callback<Boolean> {
                override fun onResponse(
                    call: Call<Boolean?>,
                    response: Response<Boolean?>
                ) {
                    if (response.isSuccessful) {
                        val autenticado = response.body()
                        if (autenticado == true) {
                            startActivity(intent) // ✅ navega só quando autenticado
                        } else {
                            Toast.makeText(this@MainActivity, "Usuário ou senha inválido!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    // ✅ CORREÇÃO 2: substituído o TODO() por um Toast de erro
                    Toast.makeText(this@MainActivity, "Erro de rede: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })

            // ✅ REMOVIDO: o intent duplicado e o startActivity fora do callback que estavam aqui
        }

        val buttCadastro = findViewById<Button>(R.id.buttCad)
        buttCadastro.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}