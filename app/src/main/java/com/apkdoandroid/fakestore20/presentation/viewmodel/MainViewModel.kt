package com.apkdoandroid.fakestore20.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apkdoandroid.fakestore20.domain.model.Produto
import com.apkdoandroid.fakestore20.domain.usecase.ProdutoUseCase
import com.apkdoandroid.fakestore20.presentation.model.Resposta
import com.apkdoandroid.fakestore20.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(private val produtoUseCase: ProdutoUseCase) : ViewModel() {

    private val _Produtos = MutableLiveData<List<Produto>>()
    var produtos : LiveData<List<Produto>> = _Produtos

    private val _Resposta = MutableLiveData<Resposta>()
    var resposta : LiveData<Resposta> = _Resposta

    private val _erroLiveData = MutableLiveData<String?>()
    val erroLiveData: LiveData<String?> get() = _erroLiveData

    fun recuperarProdutos(){
        viewModelScope.launch {


                val result = produtoUseCase.buscarProdutos()
                when(result){
                    is Resource.Success -> {
                        result.data?.let { data->
                            _Produtos.value = data
                        }
                    }
                    is Resource.Error -> {
                        result.message?.let {message->
                            _erroLiveData.value = message
                        }


                    }
                }

        }
    }
}