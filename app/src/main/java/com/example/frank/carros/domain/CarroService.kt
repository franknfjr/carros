package com.example.frank.carros.domain

import android.content.Context

object CarroService {
    // Busca os carros por tipo(classico, esportivo ou luxo)
    fun getCarros(context: Context, tipo: TipoCarro): List<Carro> {
        val tipoString = context.getString(tipo.string)

        // Cria um array vazio de carros
        val carros = mutableListOf<Carro>()

        // Cria 20 carros
        for (i in 1..20){
            val c = Carro()
            // nome do carro dinamicamente
            c.nome = "Carro $tipoString: $i"
            c.desc = "Desc " + i
            // Url Foto
            c.urlFoto = "http://www.livroandroid.com.br/livro/carros/esportivos/Ferrari_FF.png"
            carros.add(c)
        }

        return carros
    }

}