package com.example.random_land.peopledetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.random_land.R
import com.example.random_land.databinding.FragmentPeopleDetailBinding

class PeopleDetail : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentPeopleDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val peopleRandom = PeopleDetailArgs.fromBundle(requireArguments()).selectedPerson
        val viewModelFactory = PeopleDetailViewModelFactory(peopleRandom,application)
        binding.viewModel = ViewModelProvider(this,viewModelFactory)[PeopleDetailViewModel::class.java]

        (activity as AppCompatActivity).supportActionBar?.title = peopleRandom.name?.first

        return binding.root
    }


}