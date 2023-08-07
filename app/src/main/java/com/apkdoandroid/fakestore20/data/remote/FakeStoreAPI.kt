package com.apkdoandroid.fakestore20.data.remote

import com.apkdoandroid.fakestore20.data.model.ProdutoDTO
import com.apkdoandroid.fakestore20.data.model.RespostaAPI
import retrofit2.Response
import retrofit2.http.GET

interface FakeStoreAPI {
   // @GET("products")
    @GET("products/category/electronics")
    suspend fun carregarProdutos() : Response<List<ProdutoDTO>>
}