package com.example.frank.carros.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.frank.carros.R
import com.example.frank.carros.domain.TipoCarro

class CarrosFragment : BaseFragment() {
    private var tipo: TipoCarro = TipoCarro.classico

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            tipo = arguments?.getSerializable("tipo") as TipoCarro
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_carros, container, false)
        val textView = view?.findViewById<TextView>(R.id.text)
        val tipoString = getString(tipo.string)
        if (textView != null) {
            textView.text = "Carros $tipoString"
        }
        return view
    }


}
