package com.example.lovecalculator.ui.secondFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val appear: Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.appear) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            resultTxt.startAnimation(appear)
            percentageTxt.startAnimation(appear)
            val percentage =  arguments?.getString("percentage")
            val result =  arguments?.getString("result")
            resultTxt.text = arguments?.getString("result")
            when(result){
                "May be better next time."->{resultTxt.text = "Может в следующий раз повезёт"}
                "All the best!"->{resultTxt.text = "Повезло ;)"}
                "Congratulations! Good choice"->{   resultTxt.text = "Поздарвляем! идеальная пара "}
                "Can choose someone better."->{resultTxt.text=" Нужен другой партнёр ;( "}
                "Not a good choice."->{ resultTxt.text=" Так себе выбор. " }}

            percentageTxt.text = "$percentage%"
            heart.setAnimation(R.raw.spinningheart)
            tryAgain.setOnClickListener {
                findNavController().navigateUp()
            }

        }


    }


}