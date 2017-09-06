package com.example.frank.carros.activity

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
//activity nao registrada no Manifest
@SuppressLint("Registered")
/**
 * Created by Frank on 02/09/2017.
 */
open class BaseActivity : AppCompatActivity() {
    //propriedade para acessar o contexto de qualquer lugar
    protected val context: Context get() = this
    //Métodos comuns para todas activities
}