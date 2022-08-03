package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.repository.Repository

class LoveViewModel:ViewModel() {

    val repository = Repository()

    fun getLiveLoveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLoveModel(firstName,secondName)
    }
}