package com.example.frank.carros.activity

import android.os.Bundle
import com.example.frank.carros.R
import com.example.frank.carros.domain.TipoCarro
import com.example.frank.carros.extensions.addFragment
import com.example.frank.carros.extensions.setupToolbar
import com.example.frank.carros.fragments.CarrosFragment

class CarrosActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)
        // Argumentos: tipo do carro
        val tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val title = getString(tipo.string)
        // Toolbar: configura o título e o "up navigation"
        setupToolbar(R.id.toolbar, title, true)
        if (savedInstanceState == null) {
            // Adiciona o fragment no layout de marcação
            // Dentre os argumentos que foram passados para o activity, está o tipo do carro.
            addFragment(R.id.container, CarrosFragment())
        }
    }
}
