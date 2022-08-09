package com.example.lovecalculator.ui.historyFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.model.LoveModel


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        historyAdapter= HistoryAdapter{
            val loveModel = historyAdapter.getItem(it)

            val bundle = Bundle()
            Toast.makeText(requireContext(),it.toString(), Toast.LENGTH_SHORT).show()
            bundle.putSerializable("love",loveModel)



        }
        val list = App.database.LoveDao().getAll()
        historyAdapter.addItems(list!!)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(
            "love",
            viewLifecycleOwner
        ) { requestKey, bundle ->

            val loveModel = bundle.getSerializable("love") as LoveModel

            Log.e("love", "text :${loveModel.firstName }${loveModel.secondName}")
            Toast.makeText(requireContext(), loveModel.result , Toast.LENGTH_SHORT).show()

        }

        binding.recyclerView.adapter = historyAdapter

        val sort= App.database.LoveDao().sortAll() as ArrayList<LoveModel>
        historyAdapter.addList(sort)


    }


}