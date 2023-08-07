package br.com.apkdoandroid.fakestore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apkdoandroid.fakestore20.databinding.ProdutoBinding
import com.apkdoandroid.fakestore20.domain.model.Produto
import com.apkdoandroid.fakestore20.presentation.adapter.interfaces.ProdutoAdapterInterface
import com.apkdoandroid.fakestore20.presentation.viewholder.ProdutoViewHolder
import javax.inject.Inject

class ProdutoAdapter @Inject constructor() : RecyclerView.Adapter<ProdutoViewHolder>(), ProdutoAdapterInterface {

    private var produtos : List<Produto> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding  = ProdutoBinding.inflate(inflater,parent,false)

        return ProdutoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.bind(produtos.get(position))
    }

    fun attack(produtos : List<Produto>){
        this.produtos = produtos
        notifyDataSetChanged()
    }

    override fun setData(produtos: List<Produto>) {
        this.produtos = produtos
        notifyDataSetChanged()
    }
}