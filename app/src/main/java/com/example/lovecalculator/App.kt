package com.example.lovecalculator

import android.app.Application
import com.example.lovecalculator.network.LoveApi

class App:Application() {

    companion object{
        lateinit var api:LoveApi
    }


    override fun onCreate() {
        super.onCreate()
        val retrofit = RetrofitService()
        api = retrofit.api

    }
}