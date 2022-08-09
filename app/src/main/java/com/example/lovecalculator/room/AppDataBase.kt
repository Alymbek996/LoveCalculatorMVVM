package com.example.lovecalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator.model.LoveModel

@Database(entities = [LoveModel::class],version = 1)

abstract class AppDataBase : RoomDatabase() {
    abstract fun LoveDao(): LoveDao

}