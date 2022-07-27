package com.example.lovecalculator.network

import android.telecom.Call
import com.example.lovecalculator.model.LoveModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun calculate(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "5bf483a3ddmshd79b45db3bc3eedp18358ejsn0c7c9e9e6527",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ):retrofit2.Call<LoveModel>

}