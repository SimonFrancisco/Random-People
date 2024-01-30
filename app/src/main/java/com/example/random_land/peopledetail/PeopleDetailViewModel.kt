package com.example.random_land.peopledetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.random_land.network.PeopleRandom
import com.example.random_land.network.Results

class PeopleDetailViewModel(peopleRandom:Results,app:Application) : ViewModel() {
    private val _selectedPerson = MutableLiveData<Results>()
    val selectedPerson :LiveData<Results>
        get() = _selectedPerson
    init {
        _selectedPerson.value = peopleRandom
    }


}