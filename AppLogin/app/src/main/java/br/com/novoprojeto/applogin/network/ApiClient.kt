package br.com.novoprojeto.applogin.network

import br.com.novoprojeto.applogin.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {

    private val URL = "http://172.16.40.190:8080/"

    val instance : ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}