package com.app.clonemercadolivre.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.clonemercadolivre.databinding.AnuncioItemBinding
import com.app.clonemercadolivre.model.Anuncio

class AnuncioAdapter(private val context: Context, val listaAnuncios: MutableList<Anuncio>) :
    RecyclerView.Adapter<AnuncioAdapter.AnuncioAdapterViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnuncioAdapterViewHodler {
        val listItens = AnuncioItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return AnuncioAdapterViewHodler(listItens)
    }

    override fun onBindViewHolder(holder: AnuncioAdapterViewHodler, position: Int) {

        holder.imgAnuncio.setImageResource(listaAnuncios[position].img!!)
        holder.imgEmpresa.setImageResource(listaAnuncios[position].imgEmpresa!!)
        holder.diasGratis.text = listaAnuncios[position].diasGratis
        holder.desconto.text = listaAnuncios[position].desconto
        holder.nomeEmpresa.text = listaAnuncios[position].nomeEmpresa
    }

    override fun getItemCount(): Int {
        return listaAnuncios.size
    }

    inner class AnuncioAdapterViewHodler(binding: AnuncioItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgAnuncio = binding.anuncio
        val imgEmpresa = binding.imgEmpresa
        val diasGratis = binding.txtDiasGratis
        val desconto = binding.txtDesconto
        val nomeEmpresa = binding.txtNomeEmpresa
    }
}