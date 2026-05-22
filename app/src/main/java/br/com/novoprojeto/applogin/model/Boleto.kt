package br.com.novoprojeto.applogin.model

data class Boleto(
    val id: Long,
    val descricao: String,
    val valor: Double,
    val vencimento: String
)
