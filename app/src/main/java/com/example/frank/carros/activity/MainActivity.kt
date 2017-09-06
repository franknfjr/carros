package com.example.frank.carros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.frank.carros.R
import com.example.frank.carros.extensions.setupToolbar

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar)
    }
}
