package com.example.lovecalculator.ui.historyFragment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemLoveRvBinding


import com.example.lovecalculator.model.LoveModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import java.util.Collections


class HistoryAdapter(private val onClick:(position:Int)->Unit) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private var list = arrayListOf<LoveModel>()

    var onItemLongClick:((Int)->Unit)?=null



    inner class ViewHolder(private var binding: ItemLoveRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnLongClickListener {
                onItemLongClick?.invoke(position)
                true
            }

        }


        fun bind(loveModel: LoveModel) {
            with(binding){

                firstName.text = loveModel.firstName
                secondName.text = loveModel.secondName
                percentage.text = loveModel.percentage+"%"
                result.text = loveModel.result

                when(result.text){
                    "May be better next time."->{result.text = "Может в следующий раз повезёт"}
                    "All the best!"->{result.text = "Повезло ;)"}
                    "Congratulations! Good choice"->{   result.text = "Поздарвляем! идеальная пара "}
                    "Can choose someone better."->{result.text=" Нужен другой партнёр ;( "}
                    "Not a good choice."->{ result.text=" Так себе выбор. " }}

            }



            itemView.setOnClickListener {
                onClick(position)
            }


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLoveRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size

    }



    fun addItems(list: List<LoveModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }






    fun addList(list: List<LoveModel>) {
        this.list = list as ArrayList<LoveModel>
        notifyDataSetChanged()
    }



    fun getItem(pos: Int): LoveModel {
        return list[pos]
    }






}


