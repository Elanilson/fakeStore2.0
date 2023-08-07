package com.apkdoandroid.fakestore20.domain.repository

import com.apkdoandroid.fakestore20.domain.model.Produto
import com.apkdoandroid.fakestore20.util.Resource

interface ProdutoRepository {
    suspend fun buscarProdutos() : Resource<List<Produto>>
}