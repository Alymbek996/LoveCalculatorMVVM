package com.example.lovecalculator.room

import androidx.room.*
import com.example.lovecalculator.model.LoveModel


@Dao
interface LoveDao {

    @Query("SELECT * FROM LoveModel")
    fun getAll(): List<LoveModel>?


    @Insert
    fun insert(loveModel: LoveModel)

    @Update
    fun update(loveModel: LoveModel)

    @Delete
    fun delete(loveModel: LoveModel)

    @Query("SELECT * FROM lovemodel ORDER BY firstName ASC")
    fun sortAll(): List<LoveModel>




}