package com.app.clonemercadolivre.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.clonemercadolivre.databinding.ProdutoCarroselItemBinding
import com.app.clonemercadolivre.databinding.ProdutoItemBinding
import com.app.clonemercadolivre.model.Produto
import com.app.clonemercadolivre.model.ProdutoCarrosel

class ProdutoCarroselAdapter(private val context: Context, val listaProdutosCarrosel: MutableList<ProdutoCarrosel>) :
    RecyclerView.Adapter<ProdutoCarroselAdapter.ProdutoCarroselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoCarroselViewHolder {
        val itemLista = ProdutoCarroselItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProdutoCarroselViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: ProdutoCarroselViewHolder, position: Int) {
        holder.imgProduto.setImageResource(listaProdutosCarrosel[position].img!!)
        holder.precoProduto.text = listaProdutosCarrosel[position].preco
        holder.descProduto.text = listaProdutosCarrosel[position].descricao
        holder.frete.text = listaProdutosCarrosel[position].frete

    }

    override fun getItemCount() = listaProdutosCarrosel.size

    inner class ProdutoCarroselViewHolder(binding: ProdutoCarroselItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgProduto = binding.imgProdutoCarrosel
        val precoProduto = binding.precoProdutoCarrosel
        val descProduto = binding.descProdutoCarrosel
        val frete = binding.freteProdutoCarrosel
    }
}