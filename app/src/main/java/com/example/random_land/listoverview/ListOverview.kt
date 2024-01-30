package com.example.random_land.listoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.random_land.databinding.FragmentListOverviewBinding

class ListOverview : Fragment() {

    private val viewModel: ListOverviewViewModel by lazy {
        ViewModelProvider(this)[ListOverviewViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val adapter = PeopleAdapterTry()
        val recyclerView = binding.peopleRandom
        recyclerView.adapter = adapter
        viewModel.people.observe(viewLifecycleOwner){people->
            if (people.isNotEmpty()){
                adapter.setData(people[0].results)
            }
        }
        //(activity as AppCompatActivity).supportActionBar?.title = "Random People"
        return binding.root
    }


}