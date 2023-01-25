package com.app.clonemercadolivre

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.clonemercadolivre.adapter.AnuncioAdapter
import com.app.clonemercadolivre.adapter.ProdutoAdapter
import com.app.clonemercadolivre.databinding.ActivityMainBinding
import com.app.clonemercadolivre.model.Anuncio
import com.app.clonemercadolivre.model.Produto
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var anuncioAdapter: AnuncioAdapter
    private lateinit var produtoAdapter: ProdutoAdapter
    private val listaAnuncios: MutableList<Anuncio> = mutableListOf()
    private val listaProdutos: MutableList<Produto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerViewAnuncios()
        setupRecyclerViewProdutos()

        setupDrawerLayout()

    }

    private fun setupDrawerLayout() {
        val navView = binding.navigationView
        val drawerLayout = binding.drawerLayout

        binding.imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)

            toggle =
                ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_item_one -> Toast.makeText(
                        applicationContext,
                        "Inicio",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.nav_item_one -> Toast.makeText(
                        applicationContext,
                        "Buscar",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.nav_item_one -> Toast.makeText(
                        applicationContext,
                        "Notificações",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.nav_item_one -> Toast.makeText(
                        applicationContext,
                        "Minhas Compras",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.nav_item_one -> Toast.makeText(
                        applicationContext,
                        "Favoritos",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.nav_item_one -> Toast.makeText(
                        applicationContext,
                        "Fazer Logout",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                true
            }

        }


    }

    private fun setupRecyclerViewProdutos() {
        val recyclerViewProdutos = binding.rvlViewProdutos
        recyclerViewProdutos.layoutManager = GridLayoutManager(this, 2)
        recyclerViewProdutos.setHasFixedSize(true)
        produtoAdapter = ProdutoAdapter(this, listaProdutos)
        recyclerViewProdutos.adapter = produtoAdapter
        getProdutos()
    }

    private fun setupRecyclerViewAnuncios() {
        val recyclerViewAnuncios = binding.rvlAds
        recyclerViewAnuncios.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAnuncios.setHasFixedSize(true)
        anuncioAdapter = AnuncioAdapter(this, listaAnuncios)
        recyclerViewAnuncios.adapter = anuncioAdapter
        getAnuncios()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getAnuncios() {

        val anuncio01 = Anuncio(
            com.app.clonemercadolivre.R.drawable.image_ads01,
            com.app.clonemercadolivre.R.drawable.img_quadro_01,
            "7 DIAS GRÁTIS",
            "ATÉ 50% OFF",
            "HBO Max"
        )
        listaAnuncios.add(anuncio01)

        val anuncio02 = Anuncio(
            com.app.clonemercadolivre.R.drawable.image_ads02,
            com.app.clonemercadolivre.R.drawable.img_quadro_02,
            "7 DIAS GRÁTIS",
            "ATÉ 50% OFF",
            "Disney+ e Star+"
        )
        listaAnuncios.add(anuncio02)

        val anuncio03 = Anuncio(
            com.app.clonemercadolivre.R.drawable.image_ads03,
            com.app.clonemercadolivre.R.drawable.img_quadro_03,
            "7 DIAS GRÁTIS",
            "ATÉ 50% OFF",
            "Paramount+"
        )
        listaAnuncios.add(anuncio03)
    }

    private fun getProdutos() {

        val produto01 = Produto(
            com.app.clonemercadolivre.R.drawable.produto01,
            "R$ 1750,00",
            "Samsung Galaxy A03 Core Dual SIM 32 GB black 2 GB RAM",
            "Frete grátis"
        )
        listaProdutos.add(produto01)

        val produto02 = Produto(
            com.app.clonemercadolivre.R.drawable.produto02,
            "R$ 950,00",
            "Tv Philco Ptv2023225 Led Full HD",
            "Frete grpatis"
        )
        listaProdutos.add(produto02)

        val produto03 = Produto(
            com.app.clonemercadolivre.R.drawable.produto03,
            "R$ 90,00",
            "Máquina Profissional Desenho de Dragão",
            "Frete grátis"
        )
        listaProdutos.add(produto03)

        val produto04 = Produto(
            com.app.clonemercadolivre.R.drawable.produto04,
            "R$ 1350,00",
            "Bicicleta Aro 29 , Ksw 27 vel Freio Disco Hidráulico",
            "Frete grátis"
        )
        listaProdutos.add(produto04)

    }


}