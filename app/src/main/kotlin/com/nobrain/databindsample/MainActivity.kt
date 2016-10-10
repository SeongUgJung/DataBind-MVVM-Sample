package com.nobrain.databindsample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nobrain.databindsample.databinding.ActivityMainBinding
import com.nobrain.databindsample.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @JvmField
    @Inject
    var viewModel: MainViewModel? = null

    val dataBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainComponent.create().inject(this)

        dataBinding.vm = viewModel
    }

}
