package com.example.lovecalculator.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val appear: Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.appear) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animation()
        binding.calculate.setOnClickListener {
            doRequest(binding.firstNameEd.text.toString(),binding.secondNameEd.text.toString())

        }

    }

    private fun animation() {
        with(binding){
        btnSumbit.setAnimation(R.raw.circleredbutton)
        anim.setAnimation(R.raw.spinningheart)
        lovetxt.startAnimation(appear)}
    }

    private fun doRequest(firsName:String,secondName:String) {
        with(App) {
            api.calculate(firsName, secondName).enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    Log.e("ololo", "onResponse:${response.body()?.result} ${response.body()?.percentage}")
                    val result = response.body()?.result
                    val percentage = response.body()?.percentage
                    val bundle = Bundle()
                    bundle.putString("result",result)
                    bundle.putString("percentage",percentage)

                    findNavController().navigate(R.id.secondFragment,bundle)

                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })
        }
    }



}