package com.apkdoandroid.fakestore20.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.apkdoandroid.fakestore20.databinding.ProdutoBinding
import com.apkdoandroid.fakestore20.domain.model.Produto
import com.bumptech.glide.Glide

class ProdutoViewHolder( private val binding: ProdutoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(produto: Produto){
        Glide.with(binding.root).load(produto.imagem).into(binding.imageViewProduto);
        binding.textViewTituloProduto.text = produto.titulo
        binding.textViewPreco.text = "R$ ${produto.prico}"
    }
}