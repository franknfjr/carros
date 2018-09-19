package com.example.frank.carros.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.frank.carros.R
import com.example.frank.carros.R.id.progress
import com.example.frank.carros.domain.Carro
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_carro.view.*
import org.jetbrains.anko.find

// Define o construtor que recebe (carros, onclick)
class CarroAdapter(
        val carros: List<Carro>,
        val onClick: (Carro) -> Unit): RecyclerView.Adapter<CarroAdapter.CarrosViewHolder>(){

    // ViewHolder com as views
    class CarrosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tNome: TextView
        var img: ImageView
        var progress: ProgressBar
        var cardView: CardView

        // salva as views no ViewHolder
        init {
            tNome = view.findViewById<TextView>(R.id.tNome)
            img = view.findViewById<ImageView>(R.id.img)
            progress = view.findViewById<ProgressBar>(R.id.progress)
            cardView = view.findViewById<CardView>(R.id.card_view)
        }

    }

    // Retorna a quantidade de carros na lista
    override fun getItemCount() = this.carros.size

    // Infla o layout do adapter e retorna o ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrosViewHolder {
        // infla a view do adapter
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_carro, parent, false)
        // Retorna o viewHolder que contém todas as views
        val holder = CarrosViewHolder(view)
        return holder
    }

    // Faz o bind para atualizar o valor das views com os dados do Carro
    override fun onBindViewHolder(holder: CarrosViewHolder, position: Int) {
        val context = holder.itemView.context
        // Recupera o obj carro
        val carro = carros[position]
        // Atualiza os dados do carro
        holder.tNome.text = carro.nome
        holder.progress.visibility = View.VISIBLE

        // Faz o download da foto e mostra o progressBar
        Picasso.with(context).load(carro.urlFoto).fit().into(holder.img, object : com.squareup.picasso.Callback {
            override fun onSuccess() {
            // Download ok
                holder.progress.visibility = View.GONE
            }

            override fun onError() {
                holder.progress.visibility = View.GONE
            }
        })

        // Adiciona o evento de click na linha
        holder.itemView.setOnClickListener{ onClick(carro)}
    }
}
