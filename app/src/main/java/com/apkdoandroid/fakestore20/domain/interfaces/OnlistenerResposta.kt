package com.apkdoandroid.fakestore20.domain.interfaces

import com.apkdoandroid.fakestore20.presentation.model.Resposta

interface OnlistenerResposta {
    fun onSucess(result: Resposta)
    fun onFailures(mensagem : Resposta)
}