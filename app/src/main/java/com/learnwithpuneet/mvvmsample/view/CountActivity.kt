package com.learnwithpuneet.mvvmsample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.learnwithpuneet.mvvmsample.R
import com.learnwithpuneet.mvvmsample.databinding.ActivityCountBinding
import com.learnwithpuneet.mvvmsample.viewmodel.CountViewModel

class CountActivity : AppCompatActivity() {
    lateinit var activityCountBinding: ActivityCountBinding
    lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCountBinding = DataBindingUtil.setContentView(this, R.layout.activity_count)
        countViewModel = ViewModelProvider(this)[CountViewModel::class.java]

        // Set Binding ViewModel
        activityCountBinding.countViewModel = countViewModel

        countViewModel.countLiveData.observe(this) {
            activityCountBinding.tvCount.text = it.toString()
        }
    }
}