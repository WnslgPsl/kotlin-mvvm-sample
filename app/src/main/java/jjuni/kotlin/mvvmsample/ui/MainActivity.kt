package jjuni.kotlin.mvvmsample.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import jjuni.kotlin.mvvmsample.R
import jjuni.kotlin.mvvmsample.data.MainRepository
import jjuni.kotlin.mvvmsample.databinding.ActivityMainBinding
import jjuni.kotlin.mvvmsample.ui.base.ArchitectureActivity
import jjuni.kotlin.mvvmsample.viewmodel.MainViewModel
import jjuni.kotlin.mvvmsample.viewmodel.MainViewModelFatory

class MainActivity : ArchitectureActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutResId(): Int = R.layout.activity_main

    override val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, MainViewModelFatory(MainRepository())).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.let {
            it.setLifecycleOwner(this)
            it.viewModel = viewModel
        }
    }
}
