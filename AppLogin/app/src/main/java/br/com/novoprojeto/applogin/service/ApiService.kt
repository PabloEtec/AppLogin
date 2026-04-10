package br.com.novoprojeto.applogin.service

import br.com.novoprojeto.applogin.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/cadastro")
    fun cadastrarUsuario(
        @Body usuario: Usuario
    ): Call<Usuario>

}