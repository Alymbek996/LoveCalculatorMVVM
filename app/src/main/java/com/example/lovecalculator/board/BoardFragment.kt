package com.example.lovecalculator.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lovecalculator.Prefs
import com.example.lovecalculator.databinding.FragmentBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BoardFragment : Fragment() {

    private lateinit var binding:FragmentBoardBinding

    @Inject
    lateinit var prefs: Prefs


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BoardAdapter {
            findNavController().navigateUp()
            prefs.saveState()
        }
        binding.viewPager.adapter = adapter
        val dots= binding.wormDotsIndicator
        val viewPager2 = binding.viewPager
        dots.setViewPager2(viewPager2)

    }
}