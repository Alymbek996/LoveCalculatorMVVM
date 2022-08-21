package com.example.lovecalculator.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.PagerBoardBinding


class BoardAdapter(private val startClick: () -> Unit) :RecyclerView.Adapter<BoardAdapter.ViewHolder>() {


    private val titles = arrayListOf("Have a good time!","Cherishing love","Maybe someone is waiting for you!",
        "Let's find out? ;)")
    private val description = arrayListOf("You should take the time to help those who needs you"
        ,"Its now no longer to you cherish love","","")


     inner class ViewHolder(private  var binding: PagerBoardBinding):RecyclerView.ViewHolder(binding.root) {
         fun bind(position: Int) {

             with(binding) {
                 when(position){
                     0->{lottieAnim.setAnimation(R.raw.lottie1)}
                     1->{lottieAnim.setAnimation(R.raw.lottie2)}
                     2->{lottieAnim.setAnimation(R.raw.lottie3)}
                 }
                 if (position == titles.size-1){
                     btnStart.visibility = View.VISIBLE
                 }else{
                     btnStart.visibility = View.INVISIBLE
                 }
                 textTitle.text = titles[position]
                 textDesc.text = description[position]

                 btnStart.setOnClickListener {
                     startClick()
                 }
             }

         }

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PagerBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

    }

    override fun getItemCount()=titles.size



}








