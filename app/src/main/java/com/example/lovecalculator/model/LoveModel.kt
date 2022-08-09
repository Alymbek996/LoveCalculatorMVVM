package com.example.lovecalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
class LoveModel (
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
      val secondName: String,
      val percentage: String,
      val result: String,
):Serializable{
    constructor():this(0,"","","","")
}
