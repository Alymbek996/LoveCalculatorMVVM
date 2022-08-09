package com.example.lovecalculator

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {
    companion object{
        lateinit var database: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDataBase::class.java,"database")
            .allowMainThreadQueries()
            .build()
    }

}