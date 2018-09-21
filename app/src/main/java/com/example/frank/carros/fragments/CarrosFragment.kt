package com.example.frank.carros.fragments

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.frank.carros.R
import com.example.frank.carros.adapter.CarroAdapter
import com.example.frank.carros.domain.Carro
import com.example.frank.carros.domain.CarroService
import com.example.frank.carros.domain.TipoCarro
import com.example.frank.carros.extensions.toast

class CarrosFragment : BaseFragment() {
    private var tipo: TipoCarro = TipoCarro.classico
    private var carros = listOf<Carro>()
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            tipo = arguments?.getSerializable("tipo") as TipoCarro
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_carros, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskCarros()
    }

    private fun taskCarros() {
        this.carros = CarroService.getCarros(context!!, tipo)

        recyclerView?.adapter = CarroAdapter(carros, {carro -> toast("@Clicou no carro ${carro.nome}") })
    }
}
