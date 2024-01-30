package com.example.random_land.listoverview

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.random_land.network.PeopleApi
import com.example.random_land.network.PeopleRandom
import com.example.random_land.network.Results
import kotlinx.coroutines.launch
enum class PeopleApiStatus{LOADING,ERROR,DONE}
class ListOverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<PeopleApiStatus>()
    private val _response = MutableLiveData<String>()
    val response:LiveData<String>
        get() = _response
    val status: LiveData<PeopleApiStatus>
        get() = _status

    init {
        getPeopleRandom()
    }
    private val _people =MutableLiveData<List<PeopleRandom>>()
   /* private val _peopleTry = MutableLiveData<Results>()
    val peopleTry : LiveData<Results>
        get() = _peopleTry*/
    val people : LiveData<List<PeopleRandom>>
        get() = _people


    private val _navigateToSelectedPerson = MutableLiveData<PeopleRandom>()
    val navigateToSelectedPerson:LiveData<PeopleRandom>
        get() = _navigateToSelectedPerson
    private fun getPeopleRandom() {
        viewModelScope.launch {
            try {
                _status.value = PeopleApiStatus.LOADING
                val listResult = PeopleApi.retrofitService.getPeople()
                _status.value = PeopleApiStatus.DONE
                _people.value = listOf(listResult)
                //_response.value = "${listResult.results.size}"
            }
            catch (e:Exception){
                _status.value = PeopleApiStatus.ERROR
                //_response.value ="Failure ${e.message}"
                _people.value = ArrayList()
            }
        }
    }
    fun displayPersonDetails(personRandom: PeopleRandom){
        _navigateToSelectedPerson.value = personRandom
    }
    @SuppressLint("NullSafeMutableLiveData")
    fun displayPersonDetailsComplete(){
        _navigateToSelectedPerson.value = null
    }
}