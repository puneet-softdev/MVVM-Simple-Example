package com.learnwithpuneet.mvvmsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    val countLiveData: LiveData<Int>
        get() = countMutableLiveData

    private val countMutableLiveData: MutableLiveData<Int> = MutableLiveData(0)

    fun updateMyCount(){
        countMutableLiveData.value = countMutableLiveData.value?.plus(1)
    }

}