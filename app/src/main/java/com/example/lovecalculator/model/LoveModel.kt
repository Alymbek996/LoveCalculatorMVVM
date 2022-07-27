package com.example.lovecalculator.model

import com.google.gson.annotations.SerializedName

class LoveModel (
    @SerializedName("fname")
      val firstName: String,
    @SerializedName("sname")
      val secondName: String,
      val percentage: String,
      val result: String,
)
