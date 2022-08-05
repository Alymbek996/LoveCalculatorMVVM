package com.example.lovecalculator

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class Prefs @Inject constructor(private val sharedPreferences: SharedPreferences) {

    
    fun saveState(){
        sharedPreferences.edit().putBoolean("isShown",true).apply()
    }
    fun isShown():Boolean{
        return sharedPreferences.getBoolean("isShown",false)
    }






}