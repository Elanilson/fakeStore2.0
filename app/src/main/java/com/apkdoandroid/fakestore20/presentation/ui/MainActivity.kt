package com.apkdoandroid.fakestore20.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.fakestore.adapter.ProdutoAdapter
import com.apkdoandroid.fakestore20.R
import com.apkdoandroid.fakestore20.databinding.ActivityMainBinding
import com.apkdoandroid.fakestore20.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel : MainViewModel by viewModels()
    @Inject lateinit var adapter : ProdutoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        viewModel.recuperarProdutos()
        recycleviewConfig()



        observers()


    }

    private fun observers() {
        viewModel.produtos.observe(this){
                adapter.setData(it)

        }

        viewModel.erroLiveData.observe(this){
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun recycleviewConfig(){
        binding.recyclerViewProdutos.layoutManager = GridLayoutManager(this,2, RecyclerView.VERTICAL,false)
        binding.recyclerViewProdutos.adapter = adapter
    }
}