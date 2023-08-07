package com.apkdoandroid.fakestore20.presentation.model

data class Resposta (var status : Boolean ,var mensagem : String? = null){
    companion object{
        fun onSuccess(mensagem: String) : Resposta{
            return Resposta(true,mensagem)
        }
        fun onFailure(mensagem : String) : Resposta{
            return Resposta(false,mensagem)
        }
    }
}