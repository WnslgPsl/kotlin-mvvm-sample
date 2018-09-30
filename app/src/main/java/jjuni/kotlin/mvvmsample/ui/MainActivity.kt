package jjuni.kotlin.mvvmsample.ui

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import jjuni.kotlin.mvvmsample.R
import jjuni.kotlin.mvvmsample.data.MainRepository
import jjuni.kotlin.mvvmsample.databinding.ActivityMainBinding
import jjuni.kotlin.mvvmsample.ui.adapter.MainRecyclerAdapter
import jjuni.kotlin.mvvmsample.ui.base.ArchitectureActivity
import jjuni.kotlin.mvvmsample.util.addOnPropertyChanged
import jjuni.kotlin.mvvmsample.viewmodel.MainViewModel
import jjuni.kotlin.mvvmsample.viewmodel.MainViewModelFatory

class MainActivity : ArchitectureActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutResId(): Int = R.layout.activity_main

    override val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, MainViewModelFatory(MainRepository())).get(MainViewModel::class.java)
    }

    private val mainAdapter: MainRecyclerAdapter by lazy {
        MainRecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.let {
            it.setLifecycleOwner(this)
            it.viewModel = viewModel
        }

        viewDataBinding.rvItem.run {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            itemAnimator = DefaultItemAnimator()
            adapter = mainAdapter
        }

        viewModel.getSearchPhotos()

        viewModel.error.addOnPropertyChanged { Toast.makeText(this, it.get(), Toast.LENGTH_SHORT).show() }

    }

}
