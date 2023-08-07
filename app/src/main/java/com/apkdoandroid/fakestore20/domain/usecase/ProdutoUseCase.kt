package com.apkdoandroid.fakestore20.domain.usecase

import com.apkdoandroid.fakestore20.domain.model.Produto
import com.apkdoandroid.fakestore20.domain.repository.ProdutoRepository
import com.apkdoandroid.fakestore20.presentation.model.Resposta
import com.apkdoandroid.fakestore20.util.Resource
import javax.inject.Inject

class ProdutoUseCase @Inject constructor(private val produtoRepository: ProdutoRepository) {

    suspend fun buscarProdutos() : Resource<List<Produto>> {
        return try{
            produtoRepository.buscarProdutos()
          //  throw IllegalStateException("ProdutoUseCase")
        }catch (e : Exception){
            e.printStackTrace()
            Resource.Error(e.message.toString())
        }
    }

}