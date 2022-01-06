package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    lateinit var mViewModel: MeinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClik()
    }
    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MeinViewModel::class.java)

        txtContador = findViewById(R.id.txtContador)
        btnDados =findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        mViewModel.mContador.observe(this, Observer { valor ->
            txtContador.setText(valor)
        })
    }


    private fun initClik() {
        btnDados.setOnClickListener{
            mViewModel.Contado()

        }

        btnMostrar.setOnClickListener {
            Toast.makeText(applicationContext,"contador: ${mViewModel.mContador.value }" , Toast.LENGTH_SHORT).show()
        }
    }

}