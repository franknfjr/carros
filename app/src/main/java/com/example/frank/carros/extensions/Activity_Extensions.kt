package com.example.frank.carros.extensions

import android.support.v7.app.ActionBar
import android.app.Activity
import android.support.v4.app.Fragment
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import android.support.v7.widget.Toolbar

/**
 * Created by Frank on 06/09/2017.
 */
// findViewById  +  setOnclicklistener
fun AppCompatActivity.onClick(@IdRes viewId: Int, onClick: (v: android.view.View?) -> Unit) {
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}

//configura a toolbar
fun AppCompatActivity.setupToolbar(@IdRes id: Int, title: String? =  null,
                                   upNavigation: Boolean  = false): ActionBar{
    val toolbar  = findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)
    if(title != null){
        supportActionBar?.title = title
    }
    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)
    return supportActionBar!!
}

//adiciona  o fragment  no  layout
fun AppCompatActivity.addFragment(@IdRes layoutId: Int, fragment: Fragment){
    fragment.arguments = intent.extras
    val ft  =  supportFragmentManager.beginTransaction()
    ft.add(layoutId, fragment)
    ft.commit()
}