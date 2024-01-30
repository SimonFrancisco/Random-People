package com.example.random_land.peopledetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.random_land.network.PeopleRandom
import com.example.random_land.network.Results

class PeopleDetailViewModelFactory(private val peopleRandom:Results,private val application:Application):ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PeopleDetailViewModel::class.java)){
            return PeopleDetailViewModel(peopleRandom,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}