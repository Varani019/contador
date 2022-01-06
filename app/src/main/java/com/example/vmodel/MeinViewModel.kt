package com.example.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeinViewModel: ViewModel() {

    var mContador = MutableLiveData<String>().apply { value = contador.toString() }

    private var contador: Int = 0

    private fun setmContador(){
        mContador.value = contador.toString()
    }


    private fun validarContador() {
        contador++
        if (contador > 5) {
            contador = 0
        }
        setmContador()
    }

    fun Contado(){
        validarContador()
    }
}