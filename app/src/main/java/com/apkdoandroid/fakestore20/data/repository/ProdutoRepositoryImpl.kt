package com.apkdoandroid.fakestore20.data.repository

import android.util.Log
import com.apkdoandroid.fakestore20.data.model.toProduto
import com.apkdoandroid.fakestore20.data.remote.FakeStoreAPI
import com.apkdoandroid.fakestore20.domain.model.Produto
import com.apkdoandroid.fakestore20.domain.repository.ProdutoRepository
import com.apkdoandroid.fakestore20.util.Resource
import javax.inject.Inject

class ProdutoRepositoryImpl @Inject constructor(private val fakeStoreAPI: FakeStoreAPI) : ProdutoRepository {


    override suspend fun buscarProdutos(): Resource<List<Produto>> {
       try {
           val respotaAPI = fakeStoreAPI.carregarProdutos()
           if(respotaAPI.isSuccessful && respotaAPI.body() != null){
               val retorno = respotaAPI.body()
               val listaProdutos = retorno

               if(listaProdutos != null){
                   Log.d("response_apkdoandroid",listaProdutos.toString())
                   return Resource.Success(listaProdutos.map { it.toProduto() })
               }else{
                  Log.d("response_apkdoandroid","Nenhum dado retornado")
                  return Resource.Error("Nenhum dado retornado",null)
               }

           }else{
               Log.d("response_apkdoandroid",respotaAPI.message())
               return Resource.Error(respotaAPI.message(),null)
           }

       }catch (e : Exception){
           Log.d("response_apkdoandroid",e.message.toString())
           e.printStackTrace()
           return Resource.Error(e.message.toString(),null)
       }
        return Resource.Error("Lista vazia", emptyList())
    }

}