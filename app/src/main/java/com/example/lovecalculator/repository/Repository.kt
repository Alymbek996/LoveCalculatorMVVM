package com.example.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.App
import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLoveModel(firsName:String,secondName:String): MutableLiveData<LoveModel>{
        val loveModel:MutableLiveData<LoveModel> = MutableLiveData()

        App.api.calculate(firsName,secondName).enqueue(object: Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                loveModel.postValue(response.body())

            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
            }

        })
        return loveModel
    }
}