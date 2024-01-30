package com.example.random_land.peopledetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.random_land.network.Results

class PeopleDetailViewModel(peopleRandom: Results, app: Application) : ViewModel() {
    private val _selectedPerson = MutableLiveData<Results>()
    val selectedPerson: LiveData<Results>
        get() = _selectedPerson

    init {
        _selectedPerson.value = peopleRandom
    }
    val displayAllInfo = """
        Full Name: ${_selectedPerson.value?.name?.first} ${_selectedPerson.value?.name?.last} 
        Date of Birth: ${_selectedPerson.value?.dob?.date?.substring(0,10)}
        Gender: ${_selectedPerson.value?.gender}
        Age: ${_selectedPerson.value?.dob?.age} years old
        Country: ${_selectedPerson.value?.location?.country}
        State: ${_selectedPerson.value?.location?.state}
        City: ${_selectedPerson.value?.location?.city}
        Postcode: ${_selectedPerson.value?.location?.postcode}
        Email: ${_selectedPerson.value?.email}
        Phone: ${_selectedPerson.value?.phone?.filterNot { it=='-' }}
        Cell: ${_selectedPerson.value?.cell?.filterNot { it=='-' }}
        Time Zone: ${_selectedPerson.value?.location?.timezone?.offset}, ${_selectedPerson.value?.location?.timezone?.description}
        Coordinates: ${_selectedPerson.value?.location?.coordinates?.latitude},${_selectedPerson.value?.location?.coordinates?.longitude}
    """.trimIndent()


}