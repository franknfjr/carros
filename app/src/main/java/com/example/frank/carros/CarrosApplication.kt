package com.example.frank.carros

import android.app.Application
import android.util.Log

/**
 * Created by Frank on 02/09/2017.
 */
class CarrosApplication : Application() {
    private val TAG = "CarrosApplication"
    override fun onCreate() {
        super.onCreate()
        //salva a instancia para termos acesso como Singleton
        appInstance = this
    }
    //Kotlin não contem métodos e atributos estáticos, por isso add atributos/metodos em companionObject
    companion object {
        private var appInstance: CarrosApplication? = null
        fun getInstance(): CarrosApplication{
            if(appInstance == null){
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "CarrosApplication.onTerminate()")
    }
}