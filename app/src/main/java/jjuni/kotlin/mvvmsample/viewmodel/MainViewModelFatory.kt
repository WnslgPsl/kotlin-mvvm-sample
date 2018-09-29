package jjuni.kotlin.mvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jjuni.kotlin.mvvmsample.data.MainRepository

/**
 * Created by Jo on 2018. 9. 29.
 */

class MainViewModelFatory(private val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Long::class.java).newInstance(repository)
    }


}