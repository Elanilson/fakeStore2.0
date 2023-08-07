package com.apkdoandroid.fakestore20.data.model

import com.apkdoandroid.fakestore20.domain.model.Produto

data class ProdutoDTO(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
) {
    override fun toString(): String {
        return "ProdutoDTO( category='$category', description='$description', id=$id, image='$image', price=$price, rating=$rating, title='$title')"
    }
}

fun ProdutoDTO.toProduto() : Produto{
    return Produto(
        id = this.id,
        titulo = this.title,
        categoria = this.category,
        descricao = this.description,
        imagem = this.image,
        prico = this.price,
    )
}