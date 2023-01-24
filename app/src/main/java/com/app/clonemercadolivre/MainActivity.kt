package com.app.clonemercadolivre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.clonemercadolivre.adapter.AnuncioAdapter
import com.app.clonemercadolivre.adapter.ProdutoAdapter
import com.app.clonemercadolivre.databinding.ActivityMainBinding
import com.app.clonemercadolivre.model.Anuncio
import com.app.clonemercadolivre.model.Produto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var anuncioAdapter: AnuncioAdapter
    private lateinit var produtoAdapter: ProdutoAdapter
    private val listaAnuncios: MutableList<Anuncio> = mutableListOf()
    private val listaProdutos: MutableList<Produto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewAnuncios = binding.rvlAds
        recyclerViewAnuncios.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAnuncios.setHasFixedSize(true)
        anuncioAdapter = AnuncioAdapter(this, listaAnuncios)
        recyclerViewAnuncios.adapter = anuncioAdapter
        getAnuncios()

        val recyclerViewProdutos = binding.rvlViewProdutos
        recyclerViewProdutos.layoutManager = GridLayoutManager(this, 2)
        recyclerViewProdutos.setHasFixedSize(true)
        produtoAdapter = ProdutoAdapter(this, listaProdutos)
        recyclerViewProdutos.adapter = produtoAdapter
        getProdutos()

    }

    private fun getAnuncios() {

        val anuncio01 = Anuncio(
            R.drawable.image_ads2,
            R.drawable.img_quadro_03,
            "7 DIAS GRÁTIS",
            "ATÉ 50% OFF",
            "HBO Max"
        )
        listaAnuncios.add(anuncio01)

        val anuncio02 = Anuncio(
            R.drawable.image_ads3,
            R.drawable.img_quadro01,
            "7 DIAS GRÁTIS",
            "ATÉ 50% OFF",
            "Disney+ e Star+"
        )
        listaAnuncios.add(anuncio02)

        val anuncio03 = Anuncio(
            R.drawable.image_ads4,
            R.drawable.img_quadro02,
            "7 DIAS GRÁTIS",
            "ATÉ 50% OFF",
            "Paramount+"
        )
        listaAnuncios.add(anuncio03)
    }

    private fun getProdutos() {

        val produto01 = Produto(
            R.drawable.produto01,
            "R$ 1750,00",
            "Samsung Galaxy A03 Core Dual SIM 32 GB black 2 GB RAM",
            "Frete grátis"
        )
        listaProdutos.add(produto01)

        val produto02 = Produto(
            R.drawable.produto02,
            "R$ 950,00",
            "Tv Philco Ptv2023225 Led Full HD",
            "Frete grpatis"
        )
        listaProdutos.add(produto02)

        val produto03 = Produto(
            R.drawable.produto03,
            "R$ 90,00",
            "Máquina Profissional Desenho de Dragão",
            "Frete grátis"
        )
        listaProdutos.add(produto03)

        val produto04 = Produto(
            R.drawable.produto04,
            "R$ 1350,00",
            "Bicicleta Aro 29 , Ksw 27 vel Freio Disco Hidráulico",
            "Frete grátis"
        )
        listaProdutos.add(produto04)

    }

}