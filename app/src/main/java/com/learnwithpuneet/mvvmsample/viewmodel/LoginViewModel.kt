package com.learnwithpuneet.mvvmsample.viewmodel

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val loginLiveData: LiveData<String>
        get() = loginMutableLiveData

    private val loginMutableLiveData: MutableLiveData<String> = MutableLiveData()

    fun onLoginClicked(emailId: String, password: String) {
        val isLoginValid = isInputDataValid(emailId, password)
        if (isLoginValid) {
            loginMutableLiveData.value = "LogIn Success"
        }else{
            loginMutableLiveData.value = "LogIn Failure"
        }
    }


    // business logic for validation
    private fun isInputDataValid(emailId: String, password: String): Boolean {
        return !TextUtils.isEmpty(emailId) && password.length > 5;
    }
}