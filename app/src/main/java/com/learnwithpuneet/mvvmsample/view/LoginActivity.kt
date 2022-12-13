package com.learnwithpuneet.mvvmsample.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.learnwithpuneet.mvvmsample.R
import com.learnwithpuneet.mvvmsample.databinding.ActivityLoginBinding
import com.learnwithpuneet.mvvmsample.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var activityLoginBinding: ActivityLoginBinding
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        activityLoginBinding.btnLogin.setOnClickListener {
            hideKeyboard()
            loginViewModel.onLoginClicked(
                activityLoginBinding.etEmail.text.toString(),
                activityLoginBinding.etPassword.text.toString()
            )
        }

        loginViewModel.loginLiveData.observe(this) {
            activityLoginBinding.tvLoginStatus.text = it
            startActivity(Intent(this, CountActivity::class.java))
        }
    }

    private fun hideKeyboard() {
        val view = window?.decorView ?: return
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager? ?: return
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}