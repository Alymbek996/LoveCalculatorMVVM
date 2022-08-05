package com.example.lovecalculator.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.LoveViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val appear: Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.appear) }
    val viewModel:LoveViewModel by viewModels()



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
        initClickers()

    }

    private fun initClickers() {
        with(binding){
            btnSumbit.setOnClickListener {
                viewModel.getLiveLoveModel(firstNameEd.text.toString(),secondNameEd.text.toString())
                    .observe(viewLifecycleOwner,{

                        Log.e("ololo","clickers: ${it.result} ${it.percentage}")
                        val result = it.result
                        val percentage = it.percentage
                        val bundle = Bundle()
                        bundle.putString("result",result)
                        bundle.putString("percentage",percentage)

                        findNavController().navigate(R.id.secondFragment,bundle)
                    })

            }
        }
    }

    private fun animation() {
        with(binding){
        btnSumbit.setAnimation(R.raw.circleredbutton)
        anim.setAnimation(R.raw.spinningheart)
        lovetxt.startAnimation(appear)}
    }




}