package com.example.random_land.listoverview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.random_land.network.PeopleApi
import kotlinx.coroutines.launch

class ListOverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getPeopleRandom()
    }

    private fun getPeopleRandom() {
        viewModelScope.launch {
            try {
                val listResult = PeopleApi.retrofitService.getPeople()
                _response.value = "Success: ${listResult.results[5].email}"
            }
            catch (e:Exception){
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}