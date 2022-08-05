package com.example.lovecalculator

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository)
    :ViewModel() {


    fun getLiveLoveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLoveModel(firstName,secondName)
    }


}